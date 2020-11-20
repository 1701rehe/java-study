package yf513.chy.controller;


import yf513.chy.bean.User;
import yf513.chy.service.UserService;
import yf513.chy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.封装User对象
        User user = new User(username,password);

        //3.调用业务层的登录方法
        List<User> list = service.login(user); //代表查询出来的结果

        //4.判断是否查询出结果
        if(list.size() != 0) {
            //将用户名存入会话域当中
            req.getSession().setAttribute("username",username);
            //响应给客户端true
            resp.getWriter().write("true");
        }else {
            //响应给客户端false
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
