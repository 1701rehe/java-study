package yf513.chy.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查登录过滤器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class CheckLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //1.定义协议相关的请求响应对象
        HttpServletRequest request;
        HttpServletResponse response;
        try{
            //2.把协议无关的请求响应对象，转成协议相关的
            request = (HttpServletRequest)req;
            response = (HttpServletResponse)resp;
            //3.获取session域中的登录标记
            Object obj = request.getSession().getAttribute("userinfo");
            //4.判断是否已经登录
            if(obj == null){
                response.sendRedirect(request.getContextPath()+"/html/login.jsp");
                return;
            }
            //5.已登录，放行
            chain.doFilter(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
