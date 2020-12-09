package yf513.chy.dao.store;

import yf513.chy.domain.store.Course;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/25 13:34
 */
public interface CourseDao {
    int update(Course course);

    int save(Course course);

    int delete(Course course);

    Course findById(String id);

    List<Course> findAll();
}
