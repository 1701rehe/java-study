package yf513.chy.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/11 9:56
 * 实现检查登录功能
 */
@WebFilter(value = {"/addStudent.jsp","/listStudentServlet"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求和响应对象转换为HTTP协议相关对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Object username = request.getSession().getAttribute("username");
        if(username==null||"".equals(username)){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        filterChain.doFilter(request,response);
    }
}
