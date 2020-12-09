package yf513.chy.service.store.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.store.QuestionItemDao;
import yf513.chy.domain.store.QuestionItem;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.store.QuestionItemService;
import yf513.chy.utils.TransactionUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/27 14:37
 */
public class QuestionItemServiceImpl implements QuestionItemService {
    @Override
    public void save(QuestionItem questionItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            QuestionItemDao questionItemDao = MapperFactory.getMapper(sqlSession, QuestionItemDao.class);
            //id使用UUID的生成策略
            String id = new Date().toString();
            questionItem.setId(id);
            //调用Dao层操作
            questionItemDao.save(questionItem);
            //提交操作
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
    public void delete(QuestionItem questionItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            QuestionItemDao questionItemDao = MapperFactory.getMapper(sqlSession, QuestionItemDao.class);
            //调用Dao层操作
            questionItemDao.delete(questionItem);
            //提交操作
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
    public void update(QuestionItem questionItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            QuestionItemDao questionItemDao = MapperFactory.getMapper(sqlSession, QuestionItemDao.class);
            //调用Dao层操作
            questionItemDao.update(questionItem);
            //提交操作
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
    public QuestionItem findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            QuestionItemDao questionItemDao = MapperFactory.getMapper(sqlSession, QuestionItemDao.class);
            //调用Dao层操作
            return questionItemDao.findById(id);
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
    public PageInfo findAll(String questionId, int page, int size) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            QuestionItemDao questionItemDao = MapperFactory.getMapper(sqlSession, QuestionItemDao.class);
            //使用分页插件
            PageHelper.startPage(page, size);
            List<QuestionItem> all = questionItemDao.findAll(questionId);
            PageInfo pageInfo = new PageInfo<>(all);
            return pageInfo;
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
}
