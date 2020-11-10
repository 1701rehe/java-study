package yf513.yhc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/5 15:21
 */
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义一个商品价格
        int money = 1000;

        //获取访问资源路径
        String path = req.getRequestURI();
        path = path.substring(path.lastIndexOf("/"));

        //条件判断
        if ("/vip".equals(path)) {
            System.out.println("商品的原价为：" + money + "  优惠后：" + (money * 0.9));
        } else if ("/vvip".equals(path)) {
            System.out.println("商品的原价为：" + money + "  优惠后：" + (money * 0.5));
        } else {
            System.out.println("商品的价格为：" + money);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
