package com.cqupt.service;

import com.cqupt.dao.UserDAO;
import com.cqupt.domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author CHY
 * @date 2020/9/21 16:45
 */

@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void login(int id) {
        User user = userDAO.selectById(id);
        System.out.println(user);
    }
}
