package yf513.chy.web.controller.front;

import yf513.chy.domain.front.Member;
import yf513.chy.web.controller.BaseServlet;
import yf513.chy.web.controller.Code;
import yf513.chy.web.controller.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/12/4 21:38
 */
@WebServlet("/member/*")
public class MemberServlet extends BaseServlet {

    public Result register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        Member member = getData(req, Member.class);
        //调用业务层方法
        boolean flag = memberService.register(member);
        //结果查询
        return new Result("注册成功", null);
    }

    public Result login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        Member member = getData(req, Member.class);
        member = memberService.login(member.getEmail(), member.getPassword());
        if (member != null) {
            return new Result("登录成功！", member);
        } else {
            return new Result("用户名或密码错误，请重试！", false, null, Code.LOGIN_FAIL);
        }
    }

    public Result checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        Member member = getData(req, Member.class);
        //根据获取到的id去redis中查找
        String nickName = memberService.getLoginInfo(member.getId());
        return new Result("", nickName);

    }

    public Result logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        Member member = getData(req, Member.class);
        //根据获取到的id去redis中查找
        Boolean flag = memberService.logout(member.getId());
        if (flag) {
            return new Result("退出成功", flag);
        } else {
            return new Result("", false, flag, Code.LOGOUT_FAIL);
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //收集数据
//        String json = JSON.parseObject(req.getInputStream(), String.class);
//        //组织成一个实体类
//        Member member = JSON.parseObject(json, Member.class);
//        //调用业务层方法
//        boolean flag = memberService.register(member);
//
//        Result result = new Result("注册成功", null);
//
//        //返回结果（前台） 因此返回json工具
//        resp.setContentType("application/json;charset=utf-8");
//        JSON.writeJSONString(resp.getOutputStream(), result);
//
//    }
}
