package yf513.chy.service.impl;


import yf513.chy.exception.SystemException;

import java.sql.SQLException;

public class UserServiceImpl {
    public void save(){
        //业务层中如果出现了异常，就对出现异常的代码进行try...catch...处理
        //在catch中将出现的异常包装成自定义异常，同时务必将当前异常对象传入自定义异常，避免真正的异常信息消失
        try {
            throw new SQLException();
        } catch (SQLException e) {
            throw new SystemException("数据库连接超时！",e);
        }
    }
}
