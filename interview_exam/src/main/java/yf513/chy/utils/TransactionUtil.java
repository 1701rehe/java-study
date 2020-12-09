package yf513.chy.utils;

import org.apache.ibatis.session.SqlSession;

/**
 * 事务控制类
 * @author CHY
 */
public class TransactionUtil {

    /**
     * 提交释放
     *
     * @param sqlSession
     */
    public static void commit(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    /**
     * 回滚释放
     *
     * @param sqlSession
     */
    public static void rollback(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }

    /**
     * 单独释放
     *
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
