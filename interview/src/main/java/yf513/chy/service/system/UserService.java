package yf513.chy.service.system;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.system.Module;
import yf513.chy.domain.system.Role;
import yf513.chy.domain.system.User;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/24 21:40
 */
public interface UserService {
    void save(User user);

    void delete(User user);

    void update(User user);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    User findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<User> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);

    void updateRole(String userId, String[] roleIds);

    /**
     * 根据邮箱和密码登录
     * @param email 登录名
     * @param pwd 登录密码
     * @return 返回对象
     */
    User login(String email, String pwd);

    /**
     * 根据用户id查询所有的模块信息
     * @param uid 用户id
     * @return 所有的模块信息
     */
    List<Module> findModuleById(String uid);
}
