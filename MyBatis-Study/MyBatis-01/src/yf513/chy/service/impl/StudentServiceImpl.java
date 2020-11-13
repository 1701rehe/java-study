package yf513.chy.service.impl;

import yf513.chy.bean.Student;
import yf513.chy.mapper.StudentMapper;
import yf513.chy.mapper.impl.StudentMapperImpl;
import yf513.chy.service.StudentService;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/13 21:31
 */
public class StudentServiceImpl implements StudentService {

    private StudentMapper sm = new StudentMapperImpl();

    @Override
    public List<Student> selectAll() {
        return sm.selectAll();
    }

    @Override
    public Student selectById(Integer sid) {
        return sm.selectById(sid);
    }

    @Override
    public Integer insert(Student stu) {
        return sm.insert(stu);
    }

    @Override
    public Integer update(Student stu) {
        return sm.update(stu);
    }

    @Override
    public Integer delete(Integer sid) {
        return sm.delete(sid);
    }
}
