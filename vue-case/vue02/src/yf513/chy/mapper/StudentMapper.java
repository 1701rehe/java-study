package yf513.chy.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import yf513.chy.bean.Student;

import java.util.List;

/*
    学生持久层接口
 */
public interface StudentMapper {
    /*
        查询全部方法
     */
    @Select("SELECT * FROM student")
    public abstract List<Student> selectAll();

    /*
        添加数据方法
     */
    @Insert("INSERT INTO student VALUES (#{number},#{name},#{birthday},#{address})")
    public abstract void addStu(Student stu);

    /*
        修改数据方法
     */
    @Update("UPDATE student SET number=#{number},name=#{name},birthday=#{birthday},address=#{address} WHERE number=#{number}")
    public abstract void updateStu(Student stu);

    /*
        删除数据方法
     */
    @Delete("DELETE FROM student WHERE number=#{number}")
    public abstract void deleteStu(String number);
}
