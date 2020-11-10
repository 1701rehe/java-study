package yf513.yhc.servlet;

/**
 * @author CHY
 * @date 2020/11/9 21:00
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 学生登录相关功能
 */
@WebServlet("/loginStudentServlet")
public class LoginStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //判断用户名
        if(username==null||"".equals(username)){
            resp.sendRedirect("/stu/login.jsp");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        //重定向到首页index.jsp
        resp.sendRedirect("/stu/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
