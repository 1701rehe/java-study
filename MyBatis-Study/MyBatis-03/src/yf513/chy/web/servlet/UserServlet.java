package yf513.chy.web.servlet;

import yf513.chy.domain.User;
import yf513.chy.service.UserService;
import yf513.chy.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chy
 */
public class UserServlet extends HttpServlet{

    private UserService userService = new UserServiceImpl();

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
        }else if("toBatchAdd".equalsIgnoreCase(method)){
            //前往批量添加页面
            toBatchAdd(req,resp);
        }else if("saveUser".equalsIgnoreCase(method)){
            //保存用户
            saveUser(req,resp);
        }else if("batchAdd".equalsIgnoreCase(method)){
            //批量添加
            batchAdd(req,resp);
        }else if("updateUser".equalsIgnoreCase(method)){
            //更新用户
            updateUser(req,resp);
        }else if ("deleteUser".equalsIgnoreCase(method)){
            //删除用户
            deleteUser(req,resp);
        }else if("findUserById".equalsIgnoreCase(method)){
            //根据id查询
            findUserById(req,resp);
        }else if("findAllUser".equalsIgnoreCase(method)){
            //查询所有
            findAllUser(req,resp);
        }else if("login".equalsIgnoreCase(method)){
            //登录
            login(req,resp);
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
        request.getRequestDispatcher("/html/user/add.jsp").forward(request,response);
        return;
    }

    /**
     * 保存用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void saveUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            Map<String,String[]> map = req.getParameterMap();
            //2.创建对象
            User user = new User();
            //3.注册日期类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //4.使用BeanUtils封装
            BeanUtils.populate(user,map);
            //5.调用方法
            userService.save(user);
            //6.响应成功
            resp.sendRedirect(req.getContextPath()+"/users?method=findAllUser");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 更新用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            Map<String,String[]> map = req.getParameterMap();
            //2.创建对象
            User user = new User();
            //3.注册日期类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //4.使用BeanUtils封装
            BeanUtils.populate(user,map);
            //5.调用方法
            userService.update(user);
            //6.响应成功
            resp.sendRedirect(req.getContextPath()+"/users?method=findAllUser");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            String uid = req.getParameter("uid");
            //2.调用方法
            userService.delete(uid);
            //4.响应成功
            resp.sendRedirect(req.getContextPath()+"/users?method=findAllUser");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.获取请求参数的Map
            String uid = req.getParameter("uid");
            //2.调用方法
            User user = userService.findById(uid);
            //3.存入请求域中
            req.setAttribute("user",user);
            //4.响应
            req.getRequestDispatcher("/html/user/edit.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //1.调用方法
            List<User> users = userService.findAll();
            //2.存入请求域中
            req.setAttribute("users",users);
            //3.响应
            req.getRequestDispatcher("/html/user/list.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        //1.获取用户名和密码
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        //2.使用用户名和密码查询
        User user = userService.login(loginName,password);
        //3.判断是否登录成功
        if(user == null){
            request.setAttribute("errorMsg","登录失败，用户名或者密码不匹配");
            request.getRequestDispatcher("/html/login.jsp").forward(request,response);
            return;
        }
        //4.登录成功，存入session域中
        request.getSession().setAttribute("userinfo",user);
        //5.前往主页面
        response.sendRedirect(request.getContextPath()+"/html/frame.html");
        return;
    }

    /**
     * 前往批量添加页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void toBatchAdd(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("/html/user/batchadd.jsp").forward(request,response);
        return;
    }

    /**
     * 批量添加操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void batchAdd(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        try{
            //1.取出所有的请求参数
            Map<String,String[]> map = request.getParameterMap();
            //2.注册日期类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //3.初始化填充的集合
            List<User> users = new ArrayList<>();
            for(int i=0;i<3;i++){
                User user = new User();
                users.add(user);
            }

            //6.把请求参数封装到User对象中
            for(Map.Entry<String,String[]> me : map.entrySet()){
                //7.取出请求参数的key和value
                String key = me.getKey();
                String[] value = me.getValue();
                if("method".equalsIgnoreCase(key)){
                    continue;
                }
                //8.遍历value数组
                for(int i=0;i<value.length;i++) {
                    //9.取出集合中的用户
                    User user = users.get(i);
                    //10.得到用户的字节码
                    Class clazz = user.getClass();
                    //11.获取用户属性描述器
                    PropertyDescriptor pd = new PropertyDescriptor(key, clazz);
                    //12.获取写方法
                    Method method = pd.getWriteMethod();
                    //13.填充数据
                    //判断如果是日期类型
                    if(pd.getPropertyType()==Date.class){
                        method.invoke(user,new SimpleDateFormat("yyyy-MM-dd").parse(value[i]));
                    }else{
                        method.invoke(user,value[i]);
                    }
                }
            }
            //14.保存
//            System.out.println(users);
            userService.batchAdd(users);
            //15.响应
            response.sendRedirect(request.getContextPath()+"/users?method=findAllUser");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
