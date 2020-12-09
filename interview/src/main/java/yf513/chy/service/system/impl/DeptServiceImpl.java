package yf513.chy.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.system.DeptDao;
import yf513.chy.domain.system.Dept;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.system.DeptService;
import yf513.chy.utils.TransactionUtil;

import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/23 21:23
 */
public class DeptServiceImpl implements DeptService {

    @Override
    public void save(Dept dept) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            //id使用UUID的生成策略
            String id = UUID.randomUUID().toString();
            dept.setId(id);
            //调用Dao层操作
            deptDao.save(dept);
            //提交事务
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
    public void delete(Dept dept) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            deptDao.delete(dept);
            //提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Dept dept) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            deptDao.update(dept);
            //提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Dept findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            return deptDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Dept> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            return deptDao.findAll();
            //提交事务
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            sqlSession = MapperFactory.getSqlSession();
            DeptDao deptDao = MapperFactory.getMapper(sqlSession, DeptDao.class);
            //分页插件pageHelper的使用
            PageHelper.startPage(page, size); //必须存在
            List<Dept> all = deptDao.findAll();
            //分页插件 创建对象的方法
            PageInfo pageInfo = new PageInfo<>(all);
            return pageInfo;
            //提交事务
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
