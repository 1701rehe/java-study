package yf513.yhc.servlet;

import yf513.yhc.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author CHY
 * @date 2020/11/6 9:52
 */
public class StudentServlet_02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器提交的数据
        Map<String, String[]> parameterMap = req.getParameterMap();

        //通过输出流保存
//        BufferedWriter bw = new BufferedWriter(new FileWriter("d://stu.txt", true));
//        bw.write(username + "," + age + "," + grade);
//        bw.newLine();
//        bw.close();

        Student stu = new Student();
        for (String name : parameterMap.keySet()) {
            String[] value = parameterMap.get(name);
            try {
                PropertyDescriptor pd = new PropertyDescriptor(name, stu.getClass());
                //获取对应的setXXX方法
                Method writeMethod = pd.getWriteMethod();
                //执行方法
                if (value.length > 1) {
                    writeMethod.invoke(stu, (Object) value);
                } else {
                    writeMethod.invoke(stu, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        响应客户端请求（在浏览器中输出）
        PrintWriter pw = resp.getWriter();
        pw.println("Save success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
