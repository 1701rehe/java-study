package yf513.chy.servlet;

import yf513.chy.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/11/11 9:39
 */
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单中的数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String grade = req.getParameter("grade");

        //创建学生对象并赋值
        Student stu = new Student();
        stu.setUsername(username);
        stu.setAge(Integer.parseInt(age));
        stu.setGrade(Integer.parseInt(grade));
        //通过定时刷新功能响应给服务器
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\stu.txt",true));
        bw.write(stu.getUsername()+","+stu.getAge()+","+stu.getGrade());
        bw.newLine();
        bw.close();

//        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("添加成功，两秒后自动跳转到首页...");
        resp.setHeader("Refresh","2;URL=/stu/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
