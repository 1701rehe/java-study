package yf513.yhc.servlet;

import yf513.yhc.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * @author CHY
 * @date 2020/11/9 11:01
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
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for(Student s:list){
            writer.write(s.getUsername()+","+s.getAge()+","+s.getGrade());
            writer.write("<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
