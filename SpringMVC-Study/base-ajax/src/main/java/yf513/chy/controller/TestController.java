package yf513.chy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yf513.chy.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CHY
 * @date 2020/12/16 15:54
 */
@Controller
public class TestController {

    @RequestMapping("/ajaxController")
    //使用@RequestBody注解，可以将请求体内容封装到指定参数中
    public String ajaxController(@RequestBody String message) {
        System.out.println("ajax request is running----" + message);
        return "page.jsp";
    }

    @RequestMapping("/ajaxPojoToController")
    //如果处理参数是POJO，且页面发送的请求数据格式与POJO中的属性对应，@RequestBody注解可以自动映射对应请求数据到POJO中
    //注意：POJO中的属性如果请求数据中没有，属性值为null，POJO中没有的属性如果请求数据中有，不进行映射
    public String ajaxPojoToController(@RequestBody User user) {
        System.out.println("controller pojo :" + user);
        return "page.jsp";
    }

    @RequestMapping("/ajaxListToController")
    //如果处理参数是List集合且封装了POJO，且页面发送的数据是JSON格式的对象数组，数据将自动映射到集合参数中
    public String ajaxListToController(@RequestBody List<User> userList) {
        System.out.println("controller list :" + userList);
        return "page.jsp";
    }

    //使用注解@ResponseBody可以将返回的页面不进行解析，直接返回字符串，该注解可以添加到方法上方或返回值前面
    @RequestMapping("/ajaxReturnString")
    @ResponseBody
    public String ajaxReturnString() {
        System.out.println("controller return string ...");
        return "page.jsp";
    }


    @RequestMapping("/ajaxReturnJson")
    @ResponseBody
    //基于jackson技术，使用@ResponseBody注解可以将返回的POJO对象转成json格式数据
    public User ajaxReturnJson() {
        System.out.println("controller return json pojo...");
        User user = new User();
        user.setName("chy");
        user.setAge(25);
        return user;
    }

    @RequestMapping("/ajaxReturnJsonList")
    @ResponseBody
    //基于jackson技术，使用@ResponseBody注解可以将返回的保存POJO对象的集合转成json数组格式数据
    public List<User> ajaxReturnJsonList() {
        System.out.println("controller return json list...");
        User user1 = new User();
        user1.setName("Tom");
        user1.setAge(3);

        User user2 = new User();
        user2.setName("Jerry");
        user2.setAge(5);

        ArrayList<User> al = new ArrayList<>();
        al.add(user1);
        al.add(user2);

        return al;
    }

    @RequestMapping("/cross")
    @ResponseBody
    //使用@CrossOrigin开启跨域访问
    //标注在处理器方法上方表示该方法支持跨域访问
    //标注在处理器类上方表示该处理器类中的所有处理器方法均支持跨域访问
    @CrossOrigin
    public User cross(HttpServletRequest request) {
        System.out.println("controller cross..." + request.getRequestURL());
        User user = new User();
        user.setName("chy");
        user.setAge(25);
        return user;
    }
}
