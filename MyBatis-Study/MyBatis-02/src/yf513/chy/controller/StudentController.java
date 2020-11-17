package yf513.chy.controller;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import yf513.chy.bean.Student;
import yf513.chy.service.StudentService;
import yf513.chy.service.impl.StudentServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/13 21:34
 */
public class StudentController {
    //创建业务层对象
    private StudentService service = new StudentServiceImpl();

    //查询全部功能测试
    @Test
    public void selectAll() {
        List<Student> students = service.selectAll();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    //根据id查询功能测试
    @Test
    public void selectById() {
        Student stu = service.selectById(3);
        System.out.println(stu);
    }

    //新增功能测试
    @Test
    public void insert() {
        Student stu = new Student(7,"赵六",26,new Date(88,0,1));
        Integer result = service.insert(stu);
        System.out.println(result);
    }

    //修改功能测试
    @Test
    public void update() {
        Student stu = new Student(7,"赵六",30,new Date(88,0,1));
        Integer result = service.update(stu);
        System.out.println(result);
    }

    //删除功能测试
    @Test
    public void delete() {
        Integer result = service.delete(7);
        System.out.println(result);
    }

    @Test
    public void selectCondition(){
        Student stu = new Student();
        stu.setId(1);
        Student student = service.selectCondition(stu);
        System.out.println(student);
    }
}
