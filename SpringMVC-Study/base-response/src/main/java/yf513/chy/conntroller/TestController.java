package yf513.chy.conntroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import yf513.chy.domain.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/12/16 9:40
 */
@Controller
public class TestController {
    @RequestMapping("/showPageAndData1")
    public String showPageAndData1(HttpServletRequest request) {
        request.setAttribute("name", "chy");
        return "page";
    }

    @RequestMapping("/showPageAndData2")
    public String showPageAndData2(Model model) {
        model.addAttribute("name", "chy");
        Book book = new Book();
        book.setName("SpringMVC入门实战");
        book.setPrice(66.6d);
        model.addAttribute("book", book);
        return "page";
    }

    //使用ModelAndView形参传递参数，该对象还封装了页面信息
    @RequestMapping("/showPageAndData3")
    public ModelAndView showPageAndData3(ModelAndView modelAndView) {
        //ModelAndView mav = new ModelAndView();    替换形参中的参数
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        //添加数据的方式，key对value
        modelAndView.addObject("book", book);
        //添加数据的方式，key对value
        modelAndView.addObject("name", "chy");
        //设置页面的方式，该方法最后一次执行的结果生效
        modelAndView.setViewName("page");
        //返回值设定成ModelAndView对象
        return modelAndView;
    }

    //使用jackson进行json数据格式转化
    @RequestMapping("/showData1")
    public void showData1(HttpServletResponse response) throws IOException {
        response.getWriter().write("123");
    }

    //使用jackson进行json数据格式转化
    @RequestMapping("/showData2")
    @ResponseBody
    public String showData2() throws JsonProcessingException {
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);

        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(book);
    }

    //由于返回值为引用类型，自动调用jackson提供的类型转换器进行格式转换
    @RequestMapping("/showData3")
    @ResponseBody
    public Book showData3() {
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        return book;
    }

}
