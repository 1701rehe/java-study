package yf513.chy.web.controller.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.system.Role;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author CHY
 * @date 2020/12/2 14:38
 */
@WebServlet("/system/role")
public class RoleServlet extends BaseServlet {
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
        } else if ("author".equals(operation)) {
            this.author(req, resp);
        } else if ("updateRoleModule".equals(operation)) {
            this.updateRoleModule(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int size = 10;
        //获取page和size数据
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        //将数据加载到指定区域
        PageInfo all = roleService.findAll(page, size);
        req.setAttribute("page", all);
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/pages/system/role/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/system/role/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Role role = BeanUtil.fillBean(req, Role.class, "yyyy-MM-dd");
        roleService.save(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        Role role = roleService.findById(id);
        req.setAttribute("role", role);
        req.getRequestDispatcher("/WEB-INF/pages/system/role/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Role role = BeanUtil.fillBean(req, Role.class, "yyyy-MM-dd");
        roleService.update(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Role role = BeanUtil.fillBean(req, Role.class, "yyyy-MM-dd");
        roleService.delete(role);
        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    private void author(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取要授权的角色id
        String roleId = req.getParameter("id");
        //使用id查询对应的数据（角色id对应的模块信息）
        Role role = roleService.findById(roleId);
        req.setAttribute("role", role);
        //根据当前的角色id获取所有的模块数据，并加载关系数据
        List<Map> map = moduleService.findAuthorDataByRoleId(roleId);
        //将数据转账为json格式
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(map);
        req.setAttribute("roleModuleJson", json);
        //跳转到树页面中
        req.getRequestDispatcher("/WEB-INF/pages/system/role/author.jsp").forward(req, resp);
    }

    private void updateRoleModule(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取角色id和所选的模块id
        String roleId = req.getParameter("roleId");
        String moduleIds = req.getParameter("moduleIds");
        //调用业务层中的方法
        roleService.updateRoleModule(roleId, moduleIds);

        resp.sendRedirect(req.getContextPath() + "/system/role?operation=list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
