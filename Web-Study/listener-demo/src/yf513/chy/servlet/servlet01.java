package yf513.chy.servlet;

import yf513.chy.listener.HttpSessionBindingListenerDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/10 21:35
 */
@WebServlet("/servlet01")
public class servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HttpSessionBindingListenerDemo user = new HttpSessionBindingListenerDemo();
        session.setAttribute("user",user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }
}
