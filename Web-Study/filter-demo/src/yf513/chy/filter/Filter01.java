package yf513.chy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/10 15:31
 */
@WebFilter(urlPatterns = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class Filter01 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter01执行了...");
        //处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");
        //放行的操作
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
