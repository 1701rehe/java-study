package yf513.chy.mapper;

import yf513.chy.bean.Student;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/13 21:22
 */
public interface StudentMapper {
    //查询全部
    public abstract List<Student> selectAll();

    //根据id查询
    public abstract Student selectById(Integer sid);

    //新增数据
    public abstract Integer insert(Student stu);

    //修改数据
    public abstract Integer update(Student stu);

    //删除数据
    public abstract Integer delete(Integer sid);

    //多条件查询
    public abstract Student selectCondition(Student stu);
}
