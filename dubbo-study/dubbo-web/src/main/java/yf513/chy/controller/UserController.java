package yf513.chy.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yf513.chy.pojo.User;
import yf513.chy.service.UserService;

/**
 * @author CHY
 * @date 2020/12/22 20:27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //注入service
    //@Autowired
    /*
        1.从zookeeper注册中心获取userService的访问url
        2.进行远程调用RPC
        3.结果封装为一个代理对象，给变量赋值
     */
    //远程注入
    @Reference
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return userService.sayHello();
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */

    @GetMapping("{id}")
    public User find(@PathVariable int id) {
        return userService.findUserById(id);
    }
}
