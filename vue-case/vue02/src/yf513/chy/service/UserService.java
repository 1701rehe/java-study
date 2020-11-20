package yf513.chy.service;


import yf513.chy.bean.User;

import java.util.List;

/*
    业务层约束接口
 */
public interface UserService {
    /*
        登录方法
     */
    public abstract List<User> login(User user);
}
