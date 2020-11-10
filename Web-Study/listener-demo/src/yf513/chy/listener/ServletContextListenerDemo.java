package yf513.chy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * @author CHY
 * @date 2020/11/10 21:00
 */
@WebListener
public class ServletContextListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到了对象创建...");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("username","chy");
        servletContext.setAttribute("username","lmy");
        servletContext.removeAttribute("username");
        System.out.println(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到了对象销毁...");
    }
}
