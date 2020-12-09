package yf513.chy.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.system.ModuleDao;
import yf513.chy.dao.system.UserDao;
import yf513.chy.domain.system.Module;
import yf513.chy.domain.system.Role;
import yf513.chy.domain.system.User;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.system.UserService;
import yf513.chy.utils.MD5Util;
import yf513.chy.utils.TransactionUtil;

import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/24 21:42
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //id使用UUID的生成策略来获取
            String id = UUID.randomUUID().toString();
            user.setId(id);

            //密码必须经过加密处理MD5加密
            user.setPassword(MD5Util.md5(user.getPassword()));

            //3.调用Dao层操作
            userDao.save(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.调用Dao层操作
            userDao.delete(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.调用Dao层操作
            userDao.update(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User findById(String id) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.调用Dao层操作
            return userDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.调用Dao层操作
            return userDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.调用Dao层操作
            PageHelper.startPage(page, size);
            List<User> all = userDao.findAll();
            PageInfo pageInfo = new PageInfo(all);
            return pageInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateRole(String userId, String[] roleIds) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            userDao.deleteRole(userId);
            if (roleIds != null) {
                for (String roleId : roleIds) {
                    userDao.updateRole(userId, roleId);
                }
            }
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User login(String email, String pwd) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //密码必须经过加密处理MD5加密
            pwd = MD5Util.md5(pwd);
            //3.调用Dao层操作
            return userDao.findByEmailAndPwd(email, pwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Module> findModuleById(String uid) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao 查询的数据来自哪用哪个模块的功能
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            //3.调用Dao层操作
            return moduleDao.findModuleByUserId(uid);
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
