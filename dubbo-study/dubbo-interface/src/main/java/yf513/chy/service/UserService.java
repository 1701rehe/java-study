package yf513.chy.service;

import yf513.chy.pojo.User;

/**
 * @author CHY
 * @date 2020/12/22 20:14
 */
public interface UserService {
    public String sayHello();

    /**
     * 查询用户
     */
    public User findUserById(int id);
}
