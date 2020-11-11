package yf513.yhc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/11 13:35
 */
@WebServlet("/servlet02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session);
        session.setAttribute("username","chy");
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60 * 60);
        resp.addCookie(c);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
