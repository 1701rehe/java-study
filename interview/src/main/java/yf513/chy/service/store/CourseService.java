package yf513.chy.service.store;

import com.github.pagehelper.PageInfo;
import yf513.chy.domain.store.Course;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/25 13:36
 */
public interface CourseService {
    void update(Course course);

    void save(Course course);

    void delete(Course course);

    /**
     * 查询单个
     *
     * @param id 查询的条件（id）
     * @return 查询的结果，单个对象
     */
    Course findById(String id);

    /**
     * 查询全部的数据
     *
     * @return 全部数据的列表对象
     */
    List<Course> findAll();

    /**
     * 分页查询数据
     *
     * @param page 页码
     * @param size 每页显示的数据总量
     * @return PageInfo
     */
    PageInfo findAll(int page, int size);
}
