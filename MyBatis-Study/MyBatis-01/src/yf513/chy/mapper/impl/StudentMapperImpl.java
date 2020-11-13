package yf513.chy.mapper.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yf513.chy.bean.Student;
import yf513.chy.mapper.StudentMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/13 21:23
 */
public class StudentMapperImpl implements StudentMapper {
    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            //1.加载核心配置文件
            is = StudentMapperImpl.class.getClassLoader().getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.执行映射配置文件中的sql语句，并接收结果
            list = sqlSession.selectList("StudentMapper.selectAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Student selectById(Integer sid) {
        Student stu = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.执行映射配置文件中的sql语句，并接收结果
            stu = sqlSession.selectOne("StudentMapper.selectById", sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //6.返回结果
        return stu;
    }

    @Override
    public Integer insert(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.insert("StudentMapper.insert", stu);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //6.返回结果
        return result;
    }

    @Override
    public Integer update(Student stu) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.update("StudentMapper.update", stu);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //6.返回结果
        return result;
    }

    @Override
    public Integer delete(Integer sid) {
        Integer result = null;
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");

            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);

            //4.执行映射配置文件中的sql语句，并接收结果
            result = sqlSession.delete("StudentMapper.delete", sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //6.返回结果
        return result;
    }
}
