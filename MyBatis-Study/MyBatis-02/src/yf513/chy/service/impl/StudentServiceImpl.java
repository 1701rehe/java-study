package yf513.chy.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yf513.chy.bean.Student;
import yf513.chy.mapper.StudentMapper;
import yf513.chy.service.StudentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/13 21:31
 */
public class StudentServiceImpl implements StudentService {
    private static StudentMapper mapper;
    private static InputStream is;
    private static SqlSessionFactory build;
    private static SqlSession sqlSession;

    static {
        //1.加载核心配置文件
        is = StudentServiceImpl.class.getClassLoader().getResourceAsStream("MyBatisconfig.xml");
        //2.获取sqlSession工厂对象
        build = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = build.openSession(true);
        //4.获取mapper实现类对象
        mapper = sqlSession.getMapper(StudentMapper.class);
    }

    public static void close() {

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

    @Override
    public List<Student> selectAll() {
        List<Student> students = mapper.selectAll();
        close();
        return students;
    }

    @Override
    public Student selectById(Integer sid) {
        Student student = mapper.selectById(sid);
        close();
        return student;
    }

    @Override
    public Integer insert(Student stu) {
        Integer result = mapper.insert(stu);
        close();
        return result;
    }

    @Override
    public Integer update(Student stu) {
        Integer result = mapper.update(stu);
        close();
        return result;
    }

    @Override
    public Integer delete(Integer sid) {
        Integer result = mapper.delete(sid);
        close();
        return result;
    }

    @Override
    public Student selectCondition(Student stu) {
        Student student = mapper.selectCondition(stu);
        close();
        return student;
    }
}
