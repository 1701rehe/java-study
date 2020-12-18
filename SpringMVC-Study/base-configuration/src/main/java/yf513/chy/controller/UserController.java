package yf513.chy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CHY
 * @date 2020/12/15 14:15
 */
@Controller
public class UserController {

    @RequestMapping("/save")
    public String save() {
        System.out.println("mvc is running");
        return "success.jsp";
    }
}
