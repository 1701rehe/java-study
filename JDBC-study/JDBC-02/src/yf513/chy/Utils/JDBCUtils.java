package yf513.chy.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author CHY
 * @date 2020/11/12 15:06
 */
public class JDBCUtils {
    private JDBCUtils() {
    }

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    static {
        try {
            //读取配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties pr = new Properties();
            pr.load(is);

            driverClass=pr.getProperty("driverClass");
            url=pr.getProperty("url");
            username=pr.getProperty("username");
            password=pr.getProperty("password");

            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            con=DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    public static void close(Connection con, Statement stat, ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
