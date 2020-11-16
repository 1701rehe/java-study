package yf513.chy.service.impl;

import yf513.chy.dao.StudentDao;
import yf513.chy.domain.Student;
import yf513.chy.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生的业务层实现类
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {
        InputStream is = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        ArrayList<Student> students = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            students = mapper.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public Student findById(Integer sid) {
        InputStream is = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        Student stu = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            stu = mapper.findById(sid);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stu;
    }

    @Override
    public void save(Student student) {
        InputStream is = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            mapper.insert(student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Student student) {
        InputStream is = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            mapper.update(student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer sid) {
        InputStream is = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            mapper.delete(sid);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
