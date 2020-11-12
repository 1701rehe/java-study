package yf513.chy.service;

import yf513.chy.domain.Student;

import java.util.ArrayList;

/**
 * @author CHY
 * @date 2020/11/12 11:25
 */
public interface StudentService {
    //查询所有学生信息
    ArrayList<Student> findAll();

    //根据id查询学生信息
    Student findById(Integer id);

    //新增学生信息
    int insert(Student stu);

    //修改学生信息
    int update(Student stu);

    //删除学生信息
    int deleteById(Integer id);
}
