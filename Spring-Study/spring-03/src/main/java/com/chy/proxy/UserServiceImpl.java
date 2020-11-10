package com.chy.proxy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author CHY
 * @date 2020/9/21 9:39
 */
public class UserServiceImpl implements UserService {
//    private ApplicationContext ctx;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.ctx=applicationContext;
//    }

    @Override
    public void login(int id, String name) {
        System.out.println("UserServiceImpl.login-->" + id +" "+ name);
    }

    @Override
    public void register() {
        System.out.println("UserServiceImpl.register 业务运算 + DAO ");
    }


}
