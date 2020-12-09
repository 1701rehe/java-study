package yf513.chy.dao.store;

import yf513.chy.domain.store.QuestionItem;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/7 17:22
 */
public interface QuestionItemDao {
    List<QuestionItem> findByQuestionId(String questionId);
}
