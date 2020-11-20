package yf513.chy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yf513.chy.bean.Student;
import yf513.chy.mapper.StudentMapper;
import yf513.chy.service.StudentService;

import java.io.IOException;
import java.io.InputStream;

/*
    学生业务层实现类
 */
public class StudentServiceImpl implements StudentService {
    /*
        删除数据方法
     */
    @Override
    public void deleteStu(String number) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过SqlSession工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.调用实现类对象删除方法
            mapper.deleteStu(number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }

    /*
        修改数据方法
     */
    @Override
    public void updateStu(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过SqlSession工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.调用实现类对象修改方法
            mapper.updateStu(stu);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }

    /*
        添加数据方法
     */
    @Override
    public void addStu(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try{
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过SqlSession工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.调用实现类对象添加方法
            mapper.addStu(stu);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }

    /*
        分页查询功能
     */
    @Override
    public Page selectByPage(Integer currentPage, Integer pageSize) {
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
            //4.获取StudentMapper接口实现类对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //5.设置分页参数
            page = PageHelper.startPage(currentPage,pageSize);
            //6.调用实现类对象查询全部方法
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

        //8.返回结果到控制层
        return page;
    }
}
