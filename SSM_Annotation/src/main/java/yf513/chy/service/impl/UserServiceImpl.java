package yf513.chy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yf513.chy.dao.UserDao;
import yf513.chy.domain.User;
import yf513.chy.service.UserService;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/17 14:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    //分页插件的使用
    @Override
    public PageInfo<User> findAll(int page, int size) {
        PageHelper.startPage(page, size);

        List<User> all = userDao.findAll();

        return new PageInfo<User>(all);

    }

    @Override
    public User login(String userName, String password) {
        return userDao.findByUserNameAndPassword(userName, password);
    }
}
