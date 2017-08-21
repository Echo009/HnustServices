package cn.echo0.hnustservices.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/09/2017 04:21 PM
 */
@Aspect
public class PointCutDefinition {
    @Pointcut("execution(* *.*Login(..))")
    public void login() {

    }
}
