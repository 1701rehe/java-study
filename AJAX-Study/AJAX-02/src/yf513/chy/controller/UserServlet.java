package yf513.chy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应的编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取数据
        String username = req.getParameter("username");
        //调用业务层的模糊查询方法得到数据
        UserService userService = new UserServiceImpl();
        List<User> users = userService.selectLike(username);
        //将数据转换成json，响应到客户端
        ObjectMapper mapper = new ObjectMapper();
        String userJSON = mapper.writeValueAsString(users);

        resp.getWriter().write(userJSON);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
