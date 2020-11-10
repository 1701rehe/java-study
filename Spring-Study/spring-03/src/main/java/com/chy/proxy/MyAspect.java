package com.chy.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author CHY
 * @date 2020/9/21 9:36
 */
@Aspect
public class MyAspect {
    @Pointcut("execution(* *(..))")
    public void myPointcut() {
    }

    @Around(value="myPointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----aspect log ------");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
