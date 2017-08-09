package cn.echo0.hnustservices.controller.backend;

import cn.echo0.hnustservices.common.CachedInfo;
import cn.echo0.hnustservices.common.Const;
import cn.echo0.hnustservices.common.ResponseCode;
import cn.echo0.hnustservices.common.ServerResponse;
import cn.echo0.hnustservices.services.IUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 08:11 PM
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUserServices iUserServices;
    private static Logger logger =  LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse doLogin(HttpSession session,
                                  @RequestParam(value = "stuId", defaultValue = "0") int stuId,
                                  @RequestParam(value = "password", defaultValue = "") String password) {
        //has logined ?
        boolean hasLogined = (boolean) session.getAttribute(Const.LOGIN_STATE);
        CachedInfo info = (CachedInfo)session.getAttribute(Const.CACHED_INFO);
        if (hasLogined&&info!=null) {
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
        boolean hasLogined = (boolean) session.getAttribute(Const.LOGIN_STATE);
        //has not logged in
        if(!hasLogined){
            return ServerResponse.createByError();
        }
        iUserServices.doLogout(session);
        return ServerResponse.createBySuccessMessage("Logout successfully !");
    }
}
