package yf513.chy.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.store.CompanyDao;
import yf513.chy.dao.store.CourseDao;
import yf513.chy.domain.store.Company;
import yf513.chy.domain.store.Course;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.store.CourseService;
import yf513.chy.utils.TransactionUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/25 13:38
 */
public class CourseServiceImpl implements CourseService {
    @Override
    public void update(Course course) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            //获得dao代理对象
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            courseDao.update(course);
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
    public void save(Course course) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            //获得dao代理对象
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            //id使用UUID的生成策略来获取
            String id = UUID.randomUUID().toString();
            course.setId(id);

            //添加创建的时间
            course.setCreateTime(new Date());

            //3.调用Dao层操作
            courseDao.save(course);
            //4.提交事务
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
    public void delete(Course course) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            //获得dao代理对象
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            courseDao.delete(course);
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
    public Course findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            //获得dao代理对象
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            return courseDao.findById(id);
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
    public List<Course> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            //获得dao代理对象
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            return courseDao.findAll();
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
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            CourseDao courseDao = MapperFactory.getMapper(sqlSession, CourseDao.class);
            //调用Dao层操作
            PageHelper.startPage(page, size); //必须存在
            List<Course> all = courseDao.findAll();
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
