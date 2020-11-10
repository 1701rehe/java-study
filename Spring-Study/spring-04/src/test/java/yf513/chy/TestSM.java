package yf513.chy;

import com.cqupt.config.Myconfig;
import com.cqupt.dao.UserDAO;
import com.cqupt.domain.User;
import com.cqupt.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CHY
 * @date 2020/9/21 11:53
 */
public class TestSM {
    @Test
    public void test01() {
        InputStream in = TestSM.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userMapper = sqlSession.getMapper(UserDAO.class);
        List<User> users = userMapper.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void test03() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        User user = userDAO.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test04() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.login(1);
    }

    @Test
    public void test05() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = ctx.getBean("userServiceImpl", UserService.class);
        userService.login(1);
    }

    @Test
    public void test06() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Myconfig.class);
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test07() {
        // 去除单词与 `.|,` 之间的空格
        String pattern = "(\\w)(\\s+)([\\.])";
        System.out.println("asdq  .|".replaceAll(pattern, "$1$3"));
        String tel = "18304072984";
        // 括号表示组，被替换的部分$n表示第n组的内容
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{2})", "$1****$2");
        System.out.print(tel);   // output: 183****2984

    }

    @Test
    public void test08() {
        String str = "北京市(海淀区)(朝阳区)";
        String paternStr = ".*?(?=\\()";
        Pattern pattern = Pattern.compile(paternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
