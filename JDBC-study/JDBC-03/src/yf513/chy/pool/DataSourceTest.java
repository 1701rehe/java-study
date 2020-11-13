package yf513.chy.pool;

import yf513.chy.domain.Student;

import java.sql.*;

/**
 * @author CHY
 * @date 2020/11/13 14:12
 */
public class DataSourceTest {
    public static void main(String[] args) throws SQLException {
        MyDataSource ds = new MyDataSource();
        System.out.println("使用之前的连接数量：" + ds.getSize());

        Connection con = ds.getConnection();
        System.out.println(con.getClass());

        PreparedStatement ps = con.prepareStatement("select * from student");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");

                Student stu = new Student(sid, name, age, birthday);
                System.out.println(stu);
            }
        }

        resultSet.close();
        ps.close();
        con.close();
        System.out.println("使用之后的连接数量：" + ds.getSize());

    }
}
