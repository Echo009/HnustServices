package cn.echo0.hnustservices.controller.backend;

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
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse doLogin(HttpSession session,
                                  @RequestParam(value = "stuId", defaultValue = "0") int stuId,
                                  @RequestParam(value = "password", defaultValue = "") String password) {
            return ServerResponse.createByErrorCodeMessage(1,"Constructing ...");
    }
}
