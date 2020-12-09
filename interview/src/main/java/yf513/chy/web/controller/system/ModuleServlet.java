package yf513.chy.web.controller.system;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.system.Module;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * @date 2020/12/2 15:16
 */
@WebServlet("/system/module")
public class ModuleServlet extends BaseServlet {
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
        PageInfo all = moduleService.findAll(page, size);
        req.setAttribute("page", all);
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/pages/system/module/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/system/module/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Module module = BeanUtil.fillBean(req, Module.class, "yyyy-MM-dd");
        moduleService.save(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        Module module = moduleService.findById(id);
        req.setAttribute("module", module);
        req.getRequestDispatcher("/WEB-INF/pages/system/module/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Module module = BeanUtil.fillBean(req, Module.class, "yyyy-MM-dd");
        moduleService.update(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Module module = BeanUtil.fillBean(req, Module.class, "yyyy-MM-dd");
        moduleService.delete(module);
        resp.sendRedirect(req.getContextPath() + "/system/module?operation=list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
