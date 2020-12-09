package yf513.chy.dao.system;

import org.apache.ibatis.annotations.Param;
import yf513.chy.domain.system.Role;
import yf513.chy.domain.system.User;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/24 10:48
 */
public interface UserDao {
    int update(User user);

    int delete(User user);

    int save(User user);

    User findById(String id);

    List<User> findAll();

    void deleteRole(String userId);

    void updateRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     *根据账号密码查询用户
     * @param email 账号
     * @param pwd 密码（经过加密处理过）
     * @return 用户
     */
    User findByEmailAndPwd(@Param("email") String email, @Param("password") String pwd);
}
