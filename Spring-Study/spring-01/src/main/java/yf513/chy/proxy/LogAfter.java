package yf513.chy.proxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author CHY
 * @date 2020/9/19 20:22
 */
public class LogAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(returnValue);
        System.out.println(method.getName());
        System.out.println(target.getClass().getName());
    }
}
