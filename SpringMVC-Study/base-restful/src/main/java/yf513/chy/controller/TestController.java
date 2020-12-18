package yf513.chy.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author CHY
 * @date 2020/12/16 21:31
 */
//@Controller
//@ResponseBody
//设置rest风格的控制器
@RestController
//设置公共访问路径，配合下方访问路径使用
@RequestMapping("/user/")
public class TestController {
    //rest风格访问路径完整书写方式
//    @RequestMapping("/user/{id}")
//    //使用@PathVariable注解获取路径上配置的具名变量，该配置可以使用多次
//    public String restLocation(@PathVariable Integer id){
//        System.out.println("restful is running ....");
//        return "success.jsp";
//    }

    //rest风格访问路径简化书写方式，配合类注解@RequestMapping使用
//    @RequestMapping("{id}")
//    public String restLocation2(@PathVariable Integer id){
//        System.out.println("restful is running ....get:"+id);
//        return "success.jsp";
//    }

    //接收GET请求配置方式
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    //接收GET请求简化配置方式
    //@GetMapping("{id}")
    public String get(@PathVariable Integer id){
        System.out.println("restful is running ....get:"+id);
        return "success.jsp";
    }

    //接收POST请求配置方式
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    //接收POST请求简化配置方式
    //@PostMapping("{id}")
    public String post(@PathVariable Integer id){
        System.out.println("restful is running ....post:"+id);
        return "success.jsp";
    }

    //接收PUT请求简化配置方式
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    //接收PUT请求简化配置方式
    //@PutMapping("{id}")
    public String put(@PathVariable Integer id){
        System.out.println("restful is running ....put:"+id);
        return "success.jsp";
    }

    //接收DELETE请求简化配置方式
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    //接收DELETE请求简化配置方式
    //@DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("restful is running ....delete:"+id);
        return "success.jsp";
    }


}
