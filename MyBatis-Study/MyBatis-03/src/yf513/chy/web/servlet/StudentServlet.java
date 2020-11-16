package yf513.chy.web.servlet;

import yf513.chy.domain.Student;
import yf513.chy.service.StudentService;
import yf513.chy.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chy
 */
public class StudentServlet extends HttpServlet {


    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取操作名称
        String method = req.getParameter("method");
        if("toAdd".equalsIgnoreCase(method)){
            //前往添加页面
            toAdd(req,resp);
        }else if("saveStudent".equalsIgnoreCase(method)){
            //保存学生
            saveStudent(req,resp);
        }else if("updateStudent".equalsIgnoreCase(method)){
            //更新学生
            updateStudent(req,resp);
        }else if ("deleteStudent".equalsIgnoreCase(method)){
            //删除学生
            deleteStudent(req,resp);
        }else if("findStudentById".equalsIgnoreCase(method)){
            //根据id查询
            findStudentById(req,resp);
        }else if("findAllStudent".equalsIgnoreCase(method)){
            //查询所有
            findAllStudent(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }



    /**
     * 前往添加页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void toAdd(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("/html/student/add.jsp").forward(request,response);
        return;
    }

    /**
     * 保存学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void saveStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            Map<String,String[]> map = req.getParameterMap();
            //2.创建对象
            Student student = new Student();
            //3.注册日期类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //4.使用BeanUtils封装
            BeanUtils.populate(student,map);
            //4.调用方法
            studentService.save(student);
            //5.响应成功
            resp.sendRedirect(req.getContextPath()+"/students?method=findAllStudent");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 更新学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            Map<String,String[]> map = req.getParameterMap();
            //2.创建对象
            Student student = new Student();
            //3.注册日期类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //4.使用BeanUtils封装
            BeanUtils.populate(student,map);
            String sid = req.getParameter("sid");
            student.setSid(Integer.parseInt(sid));
            //4.调用方法
            studentService.update(student);
            //5.响应成功
            resp.sendRedirect(req.getContextPath()+"/students?method=findAllStudent");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            String sid = req.getParameter("sid");
            //2.调用方法
            studentService.delete(Integer.parseInt(sid));
            //4.响应成功
            resp.sendRedirect(req.getContextPath()+"/students?method=findAllStudent");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            String sid = req.getParameter("sid");
            //2.调用方法
            Student student = studentService.findById(Integer.parseInt(sid));
            //3.存入请求域中
            req.setAttribute("student",student);
            //4.响应
            req.getRequestDispatcher("/html/student/edit.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 查询所有学生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.调用方法
            List<Student> students = studentService.findAll();
            //2.存入请求域中
            req.setAttribute("students",students);
            //3.响应
            req.getRequestDispatcher("/html/student/list.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
