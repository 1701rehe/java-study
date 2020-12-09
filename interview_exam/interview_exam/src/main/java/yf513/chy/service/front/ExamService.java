package yf513.chy.service.front;


import yf513.chy.domain.front.ExamQuestion;
import yf513.chy.domain.store.Question;

import java.util.List;

/**
 * @author CHY
 * @date 2020/12/7 16:38
 */
public interface ExamService {
    List<Question> getPaper();

    /**
     *
     * @param memberId 用户id
     * @param examQuestionList 试卷题目
     * @return 提交成功与否
     */
    boolean applyPaper(String memberId, List<ExamQuestion> examQuestionList);
}
