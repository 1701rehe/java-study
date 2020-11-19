package yf513.chy.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yf513.chy.bean.User;
import yf513.chy.mapper.UserMapper;
import yf513.chy.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> selectLike(String username) {
        List<User> users = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过SqlSession工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取UserMapper接口的实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //5.调用实现类对象的模糊查询方法
            users = mapper.selectLike(username);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //7.返回结果到控制层
        return users;
    }
}
