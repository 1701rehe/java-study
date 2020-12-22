package com.chy;

import com.chy.proxy.UserService;
import com.chy.proxy.UserServiceImpl;
import com.chy.proxy.UserServiceImplCglibProxy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CHY
 * @date 2020/9/21 10:08
 */
public class TestAOP {
    private ApplicationContext ctx;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    @Test
    public void test01() {
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.login(10, "chy");
    }

    @Test
    public void test02() {
        UserService userService = UserServiceImplCglibProxy.createUserServiceCglibProxy(UserServiceImpl.class);
        userService.login(10, "chy");
    }
}
