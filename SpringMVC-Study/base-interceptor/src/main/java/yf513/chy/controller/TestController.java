package yf513.chy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CHY
 * @date 2020/12/16 16:24
 */
@Controller
public class TestController {
    @RequestMapping("/handleRun")
    public String handleRun() {
        System.out.println("业务处理器运行------------main");
        return "page.jsp";
    }
}
