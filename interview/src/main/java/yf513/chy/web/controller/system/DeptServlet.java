package yf513.chy.web.controller.system;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.system.Dept;
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
 * @date 2020/11/23 21:51
 */
@WebServlet("/system/dept")
public class DeptServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取方法名
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
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        deptService.delete(dept);
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从请求中获取数据并封装
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        deptService.update(dept);
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        Dept dept = deptService.findById(id);
        //加载所有的部门信息放入到deptList
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList",all);
        //将数据加载到指定区域
        req.setAttribute("dept", dept);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/update.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //将数据获取到，封装成一个对象
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        deptService.save(dept);
        //跳转回页面list
        resp.sendRedirect(req.getContextPath() + "/system/dept?operation=list");
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载所有的部门信息放入到deptList
        List<Dept> all = deptService.findAll();
        req.setAttribute("deptList",all);
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/add.jsp").forward(req, resp);
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
        PageInfo all = deptService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/system/dept/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
