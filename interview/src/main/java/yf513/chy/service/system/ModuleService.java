package yf513.chy.service.system;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.system.Module;

import java.util.List;
import java.util.Map;

/**
 * @author CHY
 * @date 2020/12/2 15:10
 */
public interface ModuleService {
    void save(Module module);

    void delete(Module module);

    void update(Module module);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    Module findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<Module> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);

    /**
     * 根据角色id获取对应的所有模块关联数据
     * @param roleId 角色id
     */
    List<Map> findAuthorDataByRoleId(String roleId);
}
