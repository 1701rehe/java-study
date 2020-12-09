package yf513.chy.dao.store;

import yf513.chy.domain.store.Question;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/26 11:14
 */
public interface QuestionDao {
    int update(Question question);

    int save(Question question);

    int delete(Question question);

    Question findById(String id);

    List<Question> findAll();
}
