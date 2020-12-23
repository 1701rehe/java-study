package yf513.chy.service.impl;

import org.apache.dubbo.config.annotation.Service;
import yf513.chy.pojo.User;
import yf513.chy.service.UserService;

/**
 * @author CHY
 * @date 2020/12/22 20:14
 */
//将这个类提供的方法（服务）对外发布。将访问的地址 ip 端口 路径 注册到注册中心
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String sayHello() {
        return "hello dubbo!";
    }

    @Override
    public User findUserById(int id) {
        //查询User对象
        User user = new User(1, "chy", "11122");

        return user;
    }
}
