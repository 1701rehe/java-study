package yf513.chy.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.store.CatalogDao;
import yf513.chy.domain.store.Catalog;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.store.CatalogService;
import yf513.chy.utils.TransactionUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/25 21:59
 */
public class CatalogServiceImpl implements CatalogService {
    @Override
    public void update(Catalog catalog) {
        SqlSession sqlSession = null;
        try {

            sqlSession = MapperFactory.getSqlSession();

            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            //3.调用Dao层操作
            catalogDao.update(catalog);
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
    public void delete(Catalog catalog) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            //3.调用Dao层操作
            catalogDao.delete(catalog);
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
    public void save(Catalog catalog) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            //id使用UUID的生成策略来获取
            String id = UUID.randomUUID().toString();
            catalog.setId(id);
            catalog.setCreateTime(new Date());
            //3.调用Dao层操作
            catalogDao.save(catalog);
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
    public Catalog findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            return catalogDao.findById(id);
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
    public List<Catalog> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            return catalogDao.findAll();
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
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            CatalogDao catalogDao = MapperFactory.getMapper(sqlSession, CatalogDao.class);
            //3.调用Dao层操作
            PageHelper.startPage(page, size);
            List<Catalog> all = catalogDao.findAll();
            //分页插件 创建对象的方法
            PageInfo pageInfo = new PageInfo<>(all);
            return pageInfo;
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
