package yf513.yhc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/5 10:09
 */
public class studentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

//    所有的客户端请求都会经过service方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("这是我的第一个servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
