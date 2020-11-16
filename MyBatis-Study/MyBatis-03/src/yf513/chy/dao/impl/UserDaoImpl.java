package yf513.chy.dao.impl;

import yf513.chy.dao.UserDao;
import yf513.chy.domain.User;
import yf513.chy.utils.JDBCUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户的持久层实现类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class UserDaoImpl implements UserDao {

    /*
        使用PreparedStatement登陆方法，解决注入攻击
     */
    @Override
    public User findByLoginNameAndPassword(String loginName, String password) {
        //定义必要信息
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义SQL语句
            String sql = "SELECT * FROM user WHERE loginname=? AND password=?";
            //3.获取操作对象，执行sql语句，获取结果集
            st = conn.prepareStatement(sql);
            st.setString(1,loginName);
            st.setString(2,password);

            rs = st.executeQuery();

            //4.获取结果集
            if (rs.next()) {
                //5.封装
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setUcode(rs.getString("ucode"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setDutydate(rs.getDate("dutydate"));
                user.setBirthday(rs.getDate("birthday"));
                user.setLoginname(rs.getString("loginname"));
            }
            //6.返回
            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,st,rs);
        }
    }

    /*
        使用Statement的登录方法，有注入攻击
     */
    /*@Override
    public User findByLoginNameAndPassword(String loginName, String password) {
        //定义必要信息
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        User user = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义SQL语句
            String sql = "SELECT * FROM user WHERE loginname='"+loginName+"' AND password='"+password+"'";
            System.out.println(sql);
            //3.获取操作对象，执行sql语句，获取结果集
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //4.获取结果集
            if (rs.next()) {
                //5.封装
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setUcode(rs.getString("ucode"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setDutydate(rs.getDate("dutydate"));
                user.setBirthday(rs.getDate("birthday"));
                user.setLoginname(rs.getString("loginname"));
            }
            //6.返回
            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,st,rs);
        }
    }*/

    @Override
    public List<User> findAll() {
        //定义必要信息
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> users = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.获取操作对象
            pstm = conn.prepareStatement("select * from user");
            //3.执行sql语句，获取结果集
            rs = pstm.executeQuery();
            //4.遍历结果集
            users = new ArrayList<User>();
            while (rs.next()) {
                //5.封装
                User user = new User();
                user.setUid(rs.getString("uid"));
                user.setUcode(rs.getString("ucode"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setDutydate(rs.getDate("dutydate"));
                user.setBirthday(rs.getDate("birthday"));
                user.setLoginname(rs.getString("loginname"));
                //加入到集合中
                users.add(user);
            }
            //6.返回
            return users;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,pstm,rs);
        }
    }

    @Override
    public User findById(String uid) {
        //定义必要信息
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.获取操作对象
            pstm = conn.prepareStatement("select * from user where uid = ? ");
            //3.设置参数
            pstm.setString(1,uid);
            //4.执行sql语句，获取结果集
            rs = pstm.executeQuery();
            //5.获取结果集
            if (rs.next()) {
                //6.封装
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setUcode(rs.getString("ucode"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setDutydate(rs.getDate("dutydate"));
                user.setBirthday(rs.getDate("birthday"));
                user.setLoginname(rs.getString("loginname"));
            }
            //7.返回
            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,pstm,rs);
        }
    }


    @Override
    public void update(User user) {
        //定义必要信息
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.获取操作对象
            pstm = conn.prepareStatement("update user set ucode=?,loginname=?,password=?,username=?,gender=?,birthday=?,dutydate=? where uid=?");
            //3.设置参数
            pstm.setString(1,user.getUcode());
            pstm.setString(2,user.getLoginname());
            pstm.setString(3,user.getPassword());
            pstm.setString(4,user.getUsername());
            pstm.setString(5,user.getGender());
            pstm.setDate(6,new Date(user.getBirthday().getTime()));
            pstm.setDate(7,new Date(user.getDutydate().getTime()));
            pstm.setString(8,user.getUid());
            //4.执行sql语句，获取结果集
            pstm.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,pstm);
        }
    }

    @Override
    public void delete(String uid) {
        //定义必要信息
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.获取操作对象
            pstm = conn.prepareStatement("delete from user where uid=?");
            //3.设置参数
            pstm.setString(1,uid);
            //4.执行sql语句，获取结果集
            pstm.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,pstm);
        }
    }

    /*
        添加用户数据
     */
    @Override
    public void save(User user) {
        //定义必要信息
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.获取操作对象
            pstm = conn.prepareStatement("insert into user(uid,ucode,loginname,password,username,gender,birthday,dutydate)values(?,?,?,?,?,?,?,?)");
            //3.设置参数
            pstm.setString(1,user.getUid());
            pstm.setString(2,user.getUcode());
            pstm.setString(3,user.getLoginname());
            pstm.setString(4,user.getPassword());
            pstm.setString(5,user.getUsername());
            pstm.setString(6,user.getGender());
            pstm.setDate(7,new Date(user.getBirthday().getTime()));
            pstm.setDate(8,new Date(user.getDutydate().getTime()));
            //4.执行sql语句，获取结果集
            pstm.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,pstm);
        }
    }

    /*
        支持事务的添加
     */
    @Override
    public void save(Connection connection, User user) {
        //定义必要信息
        PreparedStatement pstm = null;
        try {
            //2.获取操作对象
            pstm = connection.prepareStatement("insert into user(uid,ucode,loginname,password,username,gender,birthday,dutydate)values(?,?,?,?,?,?,?,?)");
            //3.设置参数
            pstm.setString(1,user.getUid());
            pstm.setString(2,user.getUcode());
            pstm.setString(3,user.getLoginname());
            pstm.setString(4,user.getPassword());
            pstm.setString(5,user.getUsername());
            pstm.setString(6,user.getGender());
            pstm.setDate(7,new Date(user.getBirthday().getTime()));
            pstm.setDate(8,new Date(user.getDutydate().getTime()));
            //4.执行sql语句，获取结果集
            pstm.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,pstm,null);
        }
    }
}
