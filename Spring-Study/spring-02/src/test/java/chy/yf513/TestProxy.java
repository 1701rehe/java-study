package chy.yf513;

import chy.yf513.proxy.LogMethod;
import chy.yf513.proxy.LogProxy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CHY
 * @date 2020/9/20 21:59
 */
public class TestProxy {
    private ApplicationContext ctx;
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    @Test
    public void test01(){
        LogProxy logProxy = ctx.getBean("logProxy", LogProxy.class);
        LogMethod logMethod = (LogMethod)logProxy.getInstance();
        logMethod.log(10,"qqq");
        logMethod.register();
    }
}
