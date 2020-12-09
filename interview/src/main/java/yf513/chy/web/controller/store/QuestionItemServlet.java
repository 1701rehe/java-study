package yf513.chy.web.controller.store;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.store.QuestionItem;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/27 14:48
 */
@WebServlet("/store/questionItem")
public class QuestionItemServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if ("list".equals(operation)) {
            this.list(req, resp);
        } else if ("save".equals(operation)) {
            this.save(req, resp);
        } else if ("toEdit".equals(operation)) {
            this.toEdit(req, resp);
        } else if ("edit".equals(operation)) {
            this.edit(req, resp);
        } else if ("delete".equals(operation)) {
            this.delete(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionId = req.getParameter("questionId");
        req.setAttribute("questionId", questionId);
        //调用业务层接口
        PageInfo all = questionItemService.findAll(questionId, 1, 100);
        //将数据保存到指定的位置
        req.setAttribute("page", all);
        if (req.getAttribute("operation") == null) {
            req.setAttribute("operation", "save");
        }
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/pages/store/questionItem/list.jsp").forward(req, resp);
    }


    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取数据封装
        QuestionItem questionItem = BeanUtil.fillBean(req, QuestionItem.class);
        //调用业务层接口
        questionItemService.save(questionItem);
        //页面跳转
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //调用业务层接口
        QuestionItem questionItem = questionItemService.findById(id);
        //将数据加载到指定区域
        req.setAttribute("questionItem", questionItem);
        //页面跳转
        list(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取数据封装
        QuestionItem questionItem = BeanUtil.fillBean(req, QuestionItem.class);
        //调用业务层接口
        questionItemService.update(questionItem);
        req.setAttribute("operation", "edit");
        //页面跳转
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取数据封装
        QuestionItem questionItem = BeanUtil.fillBean(req, QuestionItem.class);
        //调用业务层接口
        questionItemService.delete(questionItem);
        //页面跳转
        list(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
