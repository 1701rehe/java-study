package yf513.chy.controller;

import org.junit.Test;
import yf513.chy.domain.Student;
import yf513.chy.service.StudentService;
import yf513.chy.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author CHY
 * @date 2020/11/12 13:05
 */
public class StudentController {
    private StudentService service = new StudentServiceImpl();

    //查询所有学生信息
    @Test
    public void findALl() {
        ArrayList<Student> list = service.findALl();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    //根据id查询学生信息
    @Test
    public void findById() {
        Student stu = service.findById(5);
        System.out.println(stu);
    }

    //新增学生信息
    @Test
    public void insert() {
        Student student = new Student(6, "小卢", 24, new Date(1996,8,9));
        int result = service.insert(student);
        if (result != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //修改学生信息
    @Test
    public void update() {
        Student student = new Student(5, "小卢", 24, new Date(1996,8,9));
        student.setBirthday(new Date(96,7,9));
        int result = service.update(student);
        if (result != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    //删除学生信息
    @Test
    public void deleteById() {
        int result = service.deleteById(6);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
