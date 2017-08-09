package cn.echo0.hnustservices.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 01:27 PM
 */
public class InvokeServices {
//  http://echo0.cn:7777?echo0.cn-ironman;stuId;password
//    test ok
    public static String getValidSessionId(int stuId, String password) {
        String serviceUrl = "http://" +
                PropertiesUtil.getProperty("LoginService.host", "localhost") + "?" +
                PropertiesUtil.getProperty("LoginService.token", "void") + ";" +
                stuId + ";" + password;
        try {
//            System.out.println(serviceUrl);
            URL targetUrl = new URL(serviceUrl);
            URLConnection conn = targetUrl.openConnection();
            conn.connect();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                in.readLine();//skip the empty line
                String line=in.readLine() ;
                return line.trim();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
