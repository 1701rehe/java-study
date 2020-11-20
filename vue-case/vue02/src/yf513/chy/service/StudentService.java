package yf513.chy.service;

import com.github.pagehelper.Page;
import yf513.chy.bean.Student;

/*
    学生业务层接口
 */
public interface StudentService {
    /*
        分页查询方法
     */
    public abstract Page selectByPage(Integer currentPage, Integer pageSize);

    /*
        添加数据方法
     */
    public abstract void addStu(Student stu);

    /*
        修改数据方法
     */
    public abstract void updateStu(Student stu);

    /*
        删除数据方法
     */
    public abstract void deleteStu(String number);
}
