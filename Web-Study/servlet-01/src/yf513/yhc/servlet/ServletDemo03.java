package yf513.yhc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/5 14:50
 */
public class ServletDemo03 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("创建并初始化成功...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到了客户端的请求!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("对象已经销毁...");
    }
}
