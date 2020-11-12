package yf513.chy.dao;

import yf513.chy.Utils.JDBCUtils;
import yf513.chy.domain.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author CHY
 * @date 2020/11/12 11:25
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection con=null;
        try {
            con = JDBCUtils.getConnection();
            preparedStatement = con.prepareStatement("select * from student");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");

                Student stu = new Student(sid, name, age, birthday);
                list.add(stu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Student findById(Integer id) {
        Student stu = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection con=null;
        try {
            con=JDBCUtils.getConnection();
            preparedStatement = con.prepareStatement("select * from student where sid = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                stu = new Student(sid, name, age, birthday);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,preparedStatement,resultSet);
        }
        return stu;
    }

    @Override
    public int insert(Student stu) {
        PreparedStatement preparedStatement = null;
        Connection con =null;
        int result = 0;
        try {
            con=JDBCUtils.getConnection();
            preparedStatement = con.prepareStatement("insert into student values (?,?,?,?)");
            preparedStatement.setInt(1, stu.getSid());
            preparedStatement.setString(2, stu.getName());
            preparedStatement.setInt(3, stu.getAge());
            preparedStatement.setDate(4, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(stu.getBirthday())));
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
           JDBCUtils.close(con,preparedStatement,null);
        }
        return result;
    }

    @Override
    public int update(Student stu) {
        PreparedStatement preparedStatement = null;
        Connection con=null;
        int result = 0;
        try {
            con=JDBCUtils.getConnection();
            preparedStatement = con.prepareStatement("update student set birthday = ? where sid=?");
            preparedStatement.setDate(1, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(stu.getBirthday())));
            preparedStatement.setInt(2,stu.getSid());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,preparedStatement,null);
        }
        return result;
    }

    @Override
    public int deleteById(Integer id) {
        PreparedStatement preparedStatement = null;
        Connection con = null;
        int result = 0;
        try {
            con = JDBCUtils.getConnection();
            preparedStatement = con.prepareStatement("delete from student where sid = ?");
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(con,preparedStatement,null);
        }
        return result;
    }
}
