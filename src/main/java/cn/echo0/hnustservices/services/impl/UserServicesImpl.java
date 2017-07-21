package cn.echo0.hnustservices.services.impl;

import cn.echo0.hnustservices.common.CachedInfo;
import cn.echo0.hnustservices.common.Const;
import cn.echo0.hnustservices.pojo.User;
import cn.echo0.hnustservices.services.IUserServices;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static cn.echo0.hnustservices.util.InvokeServices.getValidSessionId;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 01:25 PM
 */
@Service("iUserServices")
public class UserServicesImpl implements IUserServices{
    public boolean doLogin(int stuId, String password, HttpSession session) {
        String sessionId = getValidSessionId(stuId,password);
        if (sessionId.length()!=0){
            // login successfully
            CachedInfo info = new CachedInfo();
            // save user info
            info.saveInfo(Const.USER,new User(stuId,password));
            // save sessionId
            info.saveInfo(Const.SESSION_ID,sessionId);
            //record loginState
            session.setAttribute(Const.LOGIN_STATE,true);
            session.setAttribute(Const.CACHED_INFO,info);
            return true;
        }
        return false;
    }
}
