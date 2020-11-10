package yf513.chy.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author CHY
 * @date 2020/11/10 21:29
 */
@WebListener
public class HttpSessionBindingListenerDemo implements HttpSessionBindingListener {
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("触发绑定事件!");
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解除和session的绑定");
    }
}
