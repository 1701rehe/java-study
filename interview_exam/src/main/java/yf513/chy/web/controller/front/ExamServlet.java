package yf513.chy.web.controller.front;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import yf513.chy.domain.front.ExamQuestion;
import yf513.chy.domain.store.Question;
import yf513.chy.web.controller.BaseServlet;
import yf513.chy.web.controller.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CHY
 * @date 2020/12/7 16:31
 */
@WebServlet("/exam/*")
public class ExamServlet extends BaseServlet {

    public Result getPaper(HttpServletRequest req, HttpServletResponse resp) {
        List<Question> questionList = examService.getPaper();
        return new Result("试卷生成成功", questionList);
    }

    public Result applyPaper(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //memberId:?????,results:[{},{}]
        //1.得到全部请求的json数据
        String json = JSONObject.parseObject(req.getInputStream(), String.class);
        //2.将json数据转换为json对象
        JSONObject jsonObject = JSON.parseObject(json);
        //3.获取当前提交试卷人的id
        String memberId = jsonObject.getObject("memberId", String.class);
        //4.获取当前提交的试卷信息
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        List<ExamQuestion> examQuestionList = jsonArray.toJavaList(ExamQuestion.class);
        for (ExamQuestion eq : examQuestionList) {
            System.out.println(eq);
        }
        boolean flag = examService.applyPaper(memberId, examQuestionList);

        return new Result("试卷提交成功！", flag);
    }
}
