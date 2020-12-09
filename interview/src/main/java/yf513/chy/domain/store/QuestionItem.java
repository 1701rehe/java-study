package yf513.chy.domain.store;

/**
 * @author CHY
 * @date 2020/11/27 14:05
 */
public class QuestionItem {
    private String id;  //ID
    private String questionId;  //题目ID
    private String content;  //选项内容
    private String picture;  //选项图片
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
}
