package yf513.chy.service.system;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.system.Dept;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/23 21:23
 */
public interface DeptService {
    void save(Dept dept);

    void delete(Dept dept);

    void update(Dept dept);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    Dept findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<Dept> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);
}
