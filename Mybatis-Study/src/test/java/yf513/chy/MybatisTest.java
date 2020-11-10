package yf513.chy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yf513.chy.dao.UserDAO;
import yf513.chy.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    InputStream in;
    SqlSession session;

    @Before
    public void init() {
        //读取配置文件
        in = MybatisTest.class.getClassLoader().getResourceAsStream("MyBatisConfig.xml");
        //获取工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //获取session
        session = factory.openSession();
    }

    @After
    public void destroy() throws IOException {
        in.close();
        session.close();
    }

    @Test
    public void test01() {
        UserDAO userDAO = session.getMapper(UserDAO.class);
        List<User> users = userDAO.findAll();

        for (User u : users) {
            System.out.println(u);
        }


    }

    @Test
    public void test02(){
        UserDAO userDAO = session.getMapper(UserDAO.class);
        User user = userDAO.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test03(){
        UserDAO userDAO = session.getMapper(UserDAO.class);
        List<User> users = userDAO.selectAll();

        for (User u : users) {
            System.out.println(u);
        }
    }
}
