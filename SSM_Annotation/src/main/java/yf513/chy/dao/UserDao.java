package yf513.chy.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import yf513.chy.domain.User;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/17 14:00
 */
@Repository
public interface UserDao {
    @Insert("insert into user(userName, password, realName, gender, birthday) values (#{userName}, #{password}, #{realName}, #{gender}, #{birthday})")
    boolean save(User user);

    @Update("update user set userName=#{userName}, password=#{password}, realName=#{realName}, gender=#{gender},birthday=#{birthday} where uuid = #{uuid}")
    boolean update(User user);

    @Delete("delete from user where uuid= #{uuid}")
    boolean delete(Integer id);

    @Select("select * from user where uuid=#{uuid}")
    User findById(Integer id);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where uuid=#{uuid} and password = #{password} ")
    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
