package yf513.yhc.servlet;

import yf513.yhc.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author CHY
 * @date 2020/11/6 9:52
 */
public class StudentServlet_01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器提交的数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String grade = req.getParameter("grade");

        //通过输出流保存
//        BufferedWriter bw = new BufferedWriter(new FileWriter("d://stu.txt", true));
//        bw.write(username + "," + age + "," + grade);
//        bw.newLine();
//        bw.close();
//

        Student stu = new Student(username, age, grade);
        System.out.println(stu);
//        响应客户端请求（在浏览器中输出）
        PrintWriter pw = resp.getWriter();
        pw.println("Save success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
