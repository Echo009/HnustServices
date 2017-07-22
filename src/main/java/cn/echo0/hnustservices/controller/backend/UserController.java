package cn.echo0.hnustservices.controller.backend;

import cn.echo0.hnustservices.common.Const;
import cn.echo0.hnustservices.common.ResponseCode;
import cn.echo0.hnustservices.common.ServerResponse;
import cn.echo0.hnustservices.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 08:11 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserServices iUserServices;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse doLogin(HttpSession session,
                                  @RequestParam(value = "stuId", defaultValue = "0") int stuId,
                                  @RequestParam(value = "password", defaultValue = "") String password) {
        // init login state
        if (session.getAttribute(Const.LOGIN_STATE) == null) {
            session.setAttribute(Const.LOGIN_STATE, false);
        }
        //has logined ?
        if ((boolean) session.getAttribute(Const.LOGIN_STATE)) {
            return ServerResponse.createBySuccessMessage("Have logged in !");
        }
        if (stuId == 0 || password.length() == 0) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if (iUserServices.doLogin(stuId, password, session)) {
            return ServerResponse.createBySuccessMessage("Login successfully !");
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.INCORRECT_USER_INFO.getCode(), ResponseCode.INCORRECT_USER_INFO.getDesc());
    }
    @RequestMapping(value = "/logout.do")
    @ResponseBody
    public ServerResponse doLogout(HttpSession session){
        //has not logged in
        if(session.getAttribute(Const.LOGIN_STATE)==null
                ||!(boolean)session.getAttribute(Const.LOGIN_STATE)){
            return ServerResponse.createByError();
        }
        iUserServices.doLogout(session);
        return ServerResponse.createBySuccessMessage("Logout successfully !");
    }
}