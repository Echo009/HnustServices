package cn.echo0.hnustservices.aspect;

import cn.echo0.hnustservices.common.ServerResponse;
import cn.echo0.hnustservices.controller.backend.UserController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/09/2017 04:42 PM
 */

@Aspect
public class Logging {
    private static Logger logger =  LoggerFactory.getLogger(UserController.class);
//    @AfterReturning(pointcut ="execution(* *.*Login(..))",returning = "response")
    public void logDologin(JoinPoint jp, ServerResponse response){
        System.out.println("  do logging !!!" + Arrays.toString(jp.getArgs()));
        logger.info(jp.getSignature().toString());
        logger.info("status:"+response.getStatus()+"  msg :" + response.getMsg());
    }
}
