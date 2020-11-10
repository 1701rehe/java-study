package yf513.chy.dao;

import yf513.chy.domain.User;

import java.util.List;

/**
 * @author CHY
 */
public interface UserDAO {
    /**
     * 查询所有操作
     * @return List
     */
    List<User> findAll();

    /**
     * 根据id查询
     * @param id 用户id
     * @return User
     */
    User selectById(int id);

    /**
     * 查询所有操作
     * @return List
     */
    List<User> selectAll();
}
