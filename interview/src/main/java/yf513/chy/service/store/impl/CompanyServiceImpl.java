package yf513.chy.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.store.CompanyDao;
import yf513.chy.domain.store.Company;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.store.CompanyService;
import yf513.chy.utils.TransactionUtil;

import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/23 16:06
 */
public class CompanyServiceImpl implements CompanyService {

    @Override
    public void save(Company company) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //id使用UUID的生成策略
            String id = UUID.randomUUID().toString();
            company.setId(id);
            //调用Dao层操作
            companyDao.save(company);
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
    public void delete(Company company) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //调用Dao层操作
            companyDao.delete(company);
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
    public void update(Company company) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //调用Dao层操作
            companyDao.update(company);
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
    public Company findById(String id) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //调用Dao层操作
            return companyDao.findById(id);
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
    public List<Company> findAll() {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //调用Dao层操作
            return companyDao.findAll();
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
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            //调用Dao层操作
            PageHelper.startPage(page, size); //必须存在
            List<Company> all = companyDao.findAll();
            //分页插件 创建对象的方法
            PageInfo pageInfo = new PageInfo<>(all);
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
}
