package yf513.chy.service.impl;

import yf513.chy.dao.UserDao;
import yf513.chy.dao.impl.UserDaoImpl;
import yf513.chy.domain.User;
import yf513.chy.service.UserService;
import yf513.chy.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(String uid) {
        return userDao.findById(uid);
    }

    @Override
    public void save(User user) {
        //1.创建ID,并把UUID中的-替换没
        String uid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        //2.给user的uid赋值
        user.setUid(uid);
        //3.生成员工编号
        user.setUcode(uid);
        //3.保存
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String uid) {
        userDao.delete(uid);
    }

    @Override
    public User login(String loginName, String password) {
        //1.调用持久层查询
        User user = userDao.findByLoginNameAndPassword(loginName,password);
        //2.返回
        return user;
    }

    /*
        事务要控制在此处
     */
    @Override
    public void batchAdd(List<User> users) {
        //获取数据库连接对象
        Connection con = JDBCUtils.getConnection();
        try {
            //开启事务
            con.setAutoCommit(false);

            for (User user : users) {
                //1.创建ID,并把UUID中的-替换
                String uid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                //2.给user的uid赋值
                user.setUid(uid);
                //3.生成员工编号
                user.setUcode(uid);

                //出现异常
                //int n = 1 / 0;

                //4.保存
                userDao.save(con,user);
            }

            //提交事务
            con.commit();

        }catch (Exception e){
            //回滚事务
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con,null);
        }
    }
}
