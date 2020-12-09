package yf513.chy.domain.store;

/**
 * @author CHY
 * @date 2020/12/7 17:14
 */
public class QuestionItem {
    private String id;  //ID
    private String questionId;  //题目ID
    private String content;  //选项内容
    private String isRight;  //是否正确答案

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
}
