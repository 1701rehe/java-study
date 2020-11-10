package yf513.yhc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/5 16:28
 */
public class ServletDemo05  extends HttpServlet {
    private ServletConfig config;

    //获取servletConfig对象
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encodingValue = config.getInitParameter("encoding");
        System.out.println(encodingValue);
        String servletName = config.getServletName();
        System.out.println(servletName);
        String file ="a.jpg";
        ServletContext servletContext = config.getServletContext();
        String mimeType = servletContext.getMimeType(file);
        System.out.println(mimeType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }
}
