package com.chy.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author CHY
 * @date 2020/12/22 11:15
 */
public class UserServiceImplCglibProxy {
    public static UserServiceImpl createUserServiceCglibProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        Callback callback = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object invoke = methodProxy.invokeSuper(o, objects);
                System.out.println("cglib");
                return invoke;
            }
        };
        enhancer.setCallback(callback);
        return (UserServiceImpl) enhancer.create();
    }
}
