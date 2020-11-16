package yf513.chy.service;

import yf513.chy.domain.User;

import java.util.List;

/**
 * 用户的业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    User findById(String uid);

    /**
     * 添加
     * @param user
     */
    void save(User user);

    /**
     * 更新
     * @param user
     */
    void update(User user);

    /**
     * 根据id删除
     * @param uid
     */
    void delete(String uid);

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName,String password);

    /**
     * 批量添加
     * @param users
     */
    void batchAdd(List<User> users);
}
