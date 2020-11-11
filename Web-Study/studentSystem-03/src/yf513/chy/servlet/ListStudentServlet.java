package yf513.chy.servlet;

import yf513.chy.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author CHY
 * @date 2020/11/11 9:39
 */
@WebServlet("/listStudentServlet")
public class ListStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建字符输入流对象，关联读取的文件
        BufferedReader br = new BufferedReader(new FileReader("d:\\stu.txt"));
        //创建集合对象，用于保存Student对象
        ArrayList<Student> list = new ArrayList<>();
        String line;
        while ((line=br.readLine())!=null){
            Student stu = new Student();
            String[] arr = line.split(",");
            stu.setUsername(arr[0]);
            stu.setAge(Integer.parseInt(arr[1]));
            stu.setGrade(Integer.parseInt(arr[2]));
            list.add(stu);
        }
        //将集合对象存入会话域中
        req.getSession().setAttribute("students",list);
        //重定向到学生列表页面
        resp.sendRedirect("/stu/listStudent.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
