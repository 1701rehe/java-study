package yf513.chy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/12/3 15:42
 */
@WebFilter(value = "/*", initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class AuthorFilter implements Filter {
    private FilterConfig filterConfig;

    /**
     * 初始化方法，获取过滤器的配置对象
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //1.定义和协议相关的请求和响应对象
        HttpServletRequest request;
        HttpServletResponse response;
        HttpSession session;
        try {
            //2.把参数转换成协议相关的对象
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) resp;
            session = request.getSession();
            //获取本次操作的uri
            String requestURI = request.getRequestURI();
            System.out.println(requestURI);
            if (requestURI.endsWith(".css")
                    || requestURI.endsWith(".js")
                    || requestURI.endsWith(".png")
                    || requestURI.endsWith(".jpg")
                    || requestURI.endsWith(".ico")
                    || requestURI.endsWith(".woff2")
                    || requestURI.endsWith("index.jsp")
                    || requestURI.endsWith("unauthorized.jsp")
                    || requestURI.endsWith("login.jsp")) {
                chain.doFilter(request, response);
                return;
            }
            //获取到的是地址中的请求参数  http://localhost/test.do?a=b&c=d&e=f
            // a=b&c=d&e=f
            String queryString = request.getQueryString();
            System.out.println(queryString);
            if (queryString != null) {
                if (queryString.endsWith("operation=login")
                        || queryString.endsWith("operation=home")
                        || queryString.endsWith("operation=logout")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            //1.当前获取到的url：   /system/dept
            requestURI = requestURI.substring(1);
            //2.当前获取到的查询参数：operation=list       operation=toEdit&id=100
            int index = queryString.indexOf("&");
            if (index != -1) {
                queryString = queryString.substring(0, index);
            }
            requestURI = requestURI + "?" + queryString;
            //获取到当前登录人允许的操作--从后台传到session中
            String authorStr = session.getAttribute("authorStr").toString();
            //比对本次操作是否在当前登录人允许的范围内
            if (authorStr.contains(requestURI)) {
                //如果允许，放行
                chain.doFilter(request, response);
                return;
            } else {
                //不允许跳转到非法访问页
                response.sendRedirect(request.getContextPath() + "/unauthorized.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        //可以做一些清理操作
    }
}
