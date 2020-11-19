package yf513.chy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yf513.chy.mapper.NewsMapper;
import yf513.chy.service.NewsService;

import java.io.IOException;
import java.io.InputStream;

public class NewsServiceImpl implements NewsService {
    @Override
    public Page pageQuery(Integer start, Integer pageSize) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Page page = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过SqlSession工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.获取NewsMapper接口的实现类对象
            NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);

            //5.封装Page对象   start:当前页码   pageSize：每页显示的条数
            page = PageHelper.startPage(start,pageSize);

            //6.调用实现类对象的查询全部方法，此时底层执行的就是MySQL的limit分页查询语句
            mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
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
        //8.返回page对象
        return page;
    }
}
