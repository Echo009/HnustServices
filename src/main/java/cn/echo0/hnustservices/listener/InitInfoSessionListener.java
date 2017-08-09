package cn.echo0.hnustservices.listener;
import cn.echo0.hnustservices.common.Const;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/25/2017 04:11 PM
 */
public class InitInfoSessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        if(session.isNew()){
            //初始化登录状态信息
            session.setAttribute(Const.LOGIN_STATE,false);
            //log
            System.out.println("Set login state : false !");
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // do nothing
    }
}
