package chy.yf513.proxy;

import lombok.Data;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author CHY
 * @date 2020/9/20 21:53
 */
@Data
public class LogProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("log")){
            System.out.println("this is cglib");
        }
        Object invoke = method.invoke(target, objects);
        return invoke;
    }
}
