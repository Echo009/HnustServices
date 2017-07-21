package cn.echo0.hnustservices.services;

import javax.servlet.http.HttpSession;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 01:23 PM
 */
public interface IUserServices {
    boolean doLogin(int stuId,String password,HttpSession session);
}
