package yf513.chy.web.controller.system;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.system.Dept;
import yf513.chy.domain.system.Module;
import yf513.chy.domain.system.Role;
import yf513.chy.domain.system.User;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/24 22:02
 */
@WebServlet("/system/user")
public class UserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if ("list".equals(operation)) {
            this.list(req, resp);
        } else if ("toAdd".equals(operation)) {
            this.toAdd(req, resp);
        } else if ("save".equals(operation)) {
            this.save(req, resp);
        } else if ("toEdit".equals(operation)) {
            this.toEdit(req, resp);
        } else if ("edit".equals(operation)) {
            this.edit(req, resp);
        } else if ("delete".equals(operation)) {
            this.delete(req, resp);
        } else if ("userRoleList".equals(operation)) {
            this.userRoleList(req, resp);
        } else if ("updateRole".equals(operation)) {
            this.updateRole(req, resp);
        } else if ("login".equals(operation)) {
            this.login(req, resp);
        } else if ("home".equals(operation)) {
            this.home(req, resp);
        } else if ("logout".equals(operation)) {
            this.logout(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        int page = 1;
        int size = 5;
        //获取page和size数据
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = userService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/user/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //将数据获取到，封装成一个对象
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.save(user);
        //跳转回页面list
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.update(user);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要先获取需要修改哪一个数据
        String id = req.getParameter("id");
        User user = userService.findById(id);

        //加载所有的部门信息放入到deptList
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList", all);
        //将数据加载到指定区域
        req.setAttribute("user", user);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/system/user/update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.delete(user);
        resp.sendRedirect(req.getContextPath() + "/system/user?operation=list");
    }

    private void userRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        //取角色列表
        User user = userService.findById(userId);
        req.setAttribute("user", user);
        List<Role> all = roleService.findAllRoleByUserId(userId);
        req.setAttribute("roleList", all);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/system/user/role.jsp").forward(req, resp);
    }

    private void updateRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String[] roleIds = request.getParameterValues("roleIds");
        userService.updateRole(userId, roleIds);
        //跳转回到页面list
        response.sendRedirect(request.getContextPath() + "/system/user?operation=list");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面中的登录信息
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");

        User user = userService.login(email, pwd);
        //需要做判断 若能通过页面提交的登录信息查询到数据库中的user对象则登录成功
        if (user != null) {
            //将用户登录信息保存在session中
            req.getSession().setAttribute("loginUser", user);
            //如果登录成功加载该用户对应的角色对应的所有模块
            List<Module> moduleList = userService.findModuleById(user.getId());
            req.getSession().setAttribute("moduleList", moduleList);

            //当前登录用户对应的可操作模块的所有url拼接成一个大的字符串  权限控制
            StringBuffer sb = new StringBuffer();
            for (Module module : moduleList) {
                sb.append(module.getCurl());
                sb.append(",");
            }
            req.getSession().setAttribute("authorStr", sb.toString());
            //跳转到主页面
            req.getRequestDispatcher("/WEB-INF/pages/home/main.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    private void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/home/home.jsp").forward(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除session中的登录信息
        req.getSession().removeAttribute("loginUser");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
