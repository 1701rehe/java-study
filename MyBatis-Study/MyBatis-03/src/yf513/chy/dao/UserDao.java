package yf513.chy.dao;

import yf513.chy.domain.User;

import java.sql.Connection;
import java.util.List;

/**
 * 用户的持久层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserDao {

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
     * 使用登录名和密码查询用户
     * @param loginName
     * @param password
     * @return
     */
    User findByLoginNameAndPassword(String loginName,String password);


    /**
     * 支持事务的添加
     * @param user
     */
    void save(Connection connection,User user);
}
