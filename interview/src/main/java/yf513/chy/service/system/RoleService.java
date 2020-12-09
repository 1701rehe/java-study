package yf513.chy.service.system;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.system.Role;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/30 16:51
 */
public interface RoleService {
    void save(Role role);

    void delete(Role role);

    void update(Role role);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    Role findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<Role> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);

    /**
     * 建立角色与模块之间的关联
     * @param roleId 角色id
     * @param moduleIds 模块id
     */
    void updateRoleModule(String roleId, String moduleIds);

    /**
     * @param userId 用户id
     * @return 所有角色
     */
    List<Role> findAllRoleByUserId(String userId);
}
