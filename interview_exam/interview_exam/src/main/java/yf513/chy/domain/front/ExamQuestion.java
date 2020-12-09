package yf513.chy.domain.front;

/**
 * @author CHY
 * @date 2020/12/8 14:45
 */
public class ExamQuestion {
    private String id;
    private String examPaperId;
    private String questionId;
    private String answer;

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "id='" + id + '\'' +
                ", examPaperId='" + examPaperId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(String examPaperId) {
        this.examPaperId = examPaperId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
