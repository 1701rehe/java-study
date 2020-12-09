package yf513.chy.dao.store;

import yf513.chy.domain.store.QuestionItem;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/27 14:22
 */
public interface QuestionItemDao {
    int save(QuestionItem questionItem);

    int delete(QuestionItem questionItem);

    int update(QuestionItem questionItem);

    QuestionItem findById(String id);

    /**
     * 根据题目id查询所有选项
     *
     * @param questionId 题目id
     * @return
     */
    List<QuestionItem> findAll(String questionId);
}
