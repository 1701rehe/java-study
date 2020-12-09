package yf513.chy.domain.store;


import java.util.List;

/**
 * @author CHY
 * @date 2020/12/7 16:40
 */
public class Question {
    private String id;           //题目ID
    private String subject;      //题干
    //    private String picture;
    private String type;         //题目类型  1:单选，2：多选，3：简答
    //    private String difficulty;   //难易程度： 1极易 2容易 3普通  4困难  5极难
    //    private String isClassic;    //是否经典面试题 0：否 1：是
    private List<QuestionItem> questionItemList;


    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
