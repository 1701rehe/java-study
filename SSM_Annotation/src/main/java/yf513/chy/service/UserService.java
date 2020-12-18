package yf513.chy.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yf513.chy.domain.User;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/17 14:06
 */
@Transactional(readOnly = true)
public interface UserService {

    @Transactional(readOnly = false)
    boolean save(User user);

    @Transactional(readOnly = false)
    boolean update(User user);

    @Transactional(readOnly = false)
    boolean delete(Integer id);

    User findById(Integer id);

    PageInfo<User> findAll(int page, int size);

    User login(String userName, String password);
}
