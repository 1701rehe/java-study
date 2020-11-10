package yf513.chy.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author CHY
 * @date 2020/9/18 21:19
 */
//增强类(额外功能) -->提高代码复用性和维护性
public class LogBefore implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("----动态代理----");
    }
}
