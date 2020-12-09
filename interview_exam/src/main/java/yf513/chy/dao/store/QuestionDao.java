package yf513.chy.dao.store;

import yf513.chy.domain.store.Question;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/7 16:48
 */
public interface QuestionDao {
    List<Question> findAll();
}
