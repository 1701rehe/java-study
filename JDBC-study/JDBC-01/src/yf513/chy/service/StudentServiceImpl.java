package yf513.chy.service;

import yf513.chy.dao.StudentDAO;
import yf513.chy.dao.StudentDAOImpl;
import yf513.chy.domain.Student;

import java.util.ArrayList;

/**
 * @author CHY
 * @date 2020/11/12 11:25
 */
public class StudentServiceImpl implements StudentService{
    private StudentDAO dao = new StudentDAOImpl();
    @Override
    public ArrayList<Student> findALl() {
        return dao.findALl();
    }

    @Override
    public Student findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public int insert(Student stu) {
        return dao.insert(stu);
    }

    @Override
    public int update(Student stu) {
        return dao.update(stu);
    }

    @Override
    public int deleteById(Integer id) {
        return dao.deleteById(id);
    }
}
