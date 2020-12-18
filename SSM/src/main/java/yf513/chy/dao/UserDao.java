package yf513.chy.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yf513.chy.domain.User;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/17 14:00
 */
@Repository
public interface UserDao {
    boolean save(User user);

    boolean update(User user);

    boolean delete(Integer id);

    User findById(Integer id);

    List<User> findAll();

    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
