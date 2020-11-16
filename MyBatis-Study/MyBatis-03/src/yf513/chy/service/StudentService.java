package yf513.chy.service;

import yf513.chy.domain.Student;

import java.util.List;

/**
 * 学生的业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAll();

    /**
     * 根据id查询学生
     * @param sid
     * @return
     */
    Student findById(Integer sid);

    /**
     * 保存
     * @param student
     */
    void save(Student student);

    /**
     * 更新
     * @param student
     */
    void update(Student student);

    /**
     * 根据id删除
     * @param sid
     */
    void delete(Integer sid);
}
