package yf513.chy.service.front.impl;

import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.front.ExamPaperDao;
import yf513.chy.dao.front.ExamQuestionDao;
import yf513.chy.dao.store.QuestionDao;
import yf513.chy.domain.front.ExamPaper;
import yf513.chy.domain.front.ExamQuestion;
import yf513.chy.domain.store.Question;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.front.ExamService;
import yf513.chy.utils.TransactionUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author CHY
 * @date 2020/12/7 16:39
 */
public class ExamServiceImpl implements ExamService {
    @Override
    public List<Question> getPaper() {
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //调用Dao层操作
            return questionDao.findAll();
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
    public boolean applyPaper(String memberId, List<ExamQuestion> examQuestionList) {
        SqlSession sqlSession = null;
        try {
            boolean flag = true;
            //获取sqlSession对象
            sqlSession = MapperFactory.getSqlSession();
            //获取dao
            ExamPaperDao examPaperDao = MapperFactory.getMapper(sqlSession, ExamPaperDao.class);
            ExamQuestionDao examQuestionDao = MapperFactory.getMapper(sqlSession, ExamQuestionDao.class);
            //调用Dao层操作
            //提交保存的试卷信息
            ExamPaper examPaper = new ExamPaper();
            String paperId = UUID.randomUUID().toString();
            examPaper.setId(paperId);
            examPaper.setApplyTime(new Date());
            examPaper.setMemberId(memberId);
            examPaper.setState("1");
            flag = flag && examPaperDao.save(examPaper) > 0;
            //提交保存的试卷中的所有题目对应的答案信息
            for (ExamQuestion eq : examQuestionList) {
                eq.setId(UUID.randomUUID().toString());
                eq.setExamPaperId(paperId);

                flag = flag && examQuestionDao.save(eq) > 0;
            }

            TransactionUtil.commit(sqlSession);
            return flag;
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
}
