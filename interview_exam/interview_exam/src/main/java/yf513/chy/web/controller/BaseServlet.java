package yf513.chy.web.controller;

import com.alibaba.fastjson.JSON;
import yf513.chy.service.front.ExamService;
import yf513.chy.service.front.MemberService;
import yf513.chy.service.front.impl.ExamServiceImpl;
import yf513.chy.service.front.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author CHY
 * @date 2020/12/4 22:04
 */
public class BaseServlet extends HttpServlet {
    protected MemberService memberService;
    protected ExamService examService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberServiceImpl();
        examService = new ExamServiceImpl();
    }

    protected <T> T getData(HttpServletRequest req, Class<T> clazz) throws IOException {
        //收集数据
        String json = JSON.parseObject(req.getInputStream(), String.class);
        //组织成一个实体类
        return JSON.parseObject(json, clazz);
    }

    protected void returnData(HttpServletResponse resp, Result result) throws IOException {
        //返回结果（前台） 因此返回json工具
        resp.setContentType("application/json;charset=utf-8");
        JSON.writeJSONString(resp.getOutputStream(), result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int lastIndex = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(lastIndex + 1, requestURI.length());
        //获取到了方法名叫做url的方法，然后执行，传递参数即可
        Class<? extends BaseServlet> clazz = this.getClass();
        try {
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Result result = (Result) method.invoke(this, req, resp);
            //返回结果（前台） 因此返回json
            returnData(resp, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
