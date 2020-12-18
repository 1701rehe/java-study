package yf513.chy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yf513.chy.domain.User;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author CHY
 * @date 2020/12/15 20:30
 */
@Controller
public class TestController {

    @RequestMapping("/requestParam1")
    public String requestParam1(String name, String age) throws UnsupportedEncodingException {
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("name=" + name + ",age=" + age);
        return "page.jsp";
    }

    @RequestMapping("/requestParam2")
    public String requestParam2(@RequestParam(
            name = "userName",
            required = true,
            defaultValue = "chy") String name) {

        System.out.println("name=" + name);
        return "page.jsp";
    }

    @RequestMapping("/requestParam3")
    public String requestParam3(User user) {
        System.out.println(user);
        return "page.jsp";
    }

    //http://localhost/requestParam5?address.province=beijing
    @RequestMapping("/requestParam5")
    public String requestParam5(User user) {
        System.out.println("user.address=" + user.getAddress().getProvince());
        return "page.jsp";
    }

    // http://localhost/requestParam6?nick=Jockme&nick=zahc
    @RequestMapping("/requestParam6")
    public String requestParam6(String[] nick) {
        System.out.println(nick[0] + "," + nick[1]);
        return "page.jsp";
    }

    //http://localhost/requestParam7?nick=Jockme&nick=zahc
    //单独的List集合参数 需要使用 @RequestParam注解
    @RequestMapping("/requestParam7")
    public String requestParam7(@RequestParam("nick") List<String> nick) {
        System.out.println(nick);
        return "page.jsp";
    }

    @RequestMapping("/requestParam8")
    public String requestParam8(Date date) {
        System.out.println("date=" + new SimpleDateFormat("yyyy-MM-dd").format(date));
        return "page.jsp";
    }
}
