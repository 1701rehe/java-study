package yf513.chy.listener;

import sun.java2d.pipe.SpanIterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author CHY
 * @date 2020/11/10 21:09
 */
@WebListener
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("监听到了属性的添加...");
        ServletContext servletContext = scae.getServletContext();
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("监听到了属性的替换...");
        ServletContext servletContext = scae.getServletContext();
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("监听到了属性的移除...");
    }
}
