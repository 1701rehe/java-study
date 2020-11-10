package yf513.chy.proxy;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author CHY
 * @date 2020/9/20 16:41
 */
public class StudentJDKProxy implements InvocationHandler {
    private Object target;

    public StudentJDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----JDK----");
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
