package yf513.chy.service;


import yf513.chy.bean.User;

import java.util.List;

public interface UserService {
    /*
        模糊查询
     */
    public abstract List<User> selectLike(String username);
}
