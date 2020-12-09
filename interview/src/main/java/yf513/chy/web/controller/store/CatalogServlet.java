package yf513.chy.web.controller.store;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.store.Catalog;
import yf513.chy.domain.store.Course;
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
 * @date 2020/11/26 9:41
 */
@WebServlet("/store/catalog")
public class CatalogServlet extends BaseServlet {
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
        int size = 5;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = catalogService.findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载所有的学科信息放入到courseList
        List<Course> all = courseService.findAll();
        req.setAttribute("courseList", all);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.save(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        Catalog catalog = catalogService.findById(id);
        //将数据加载到指定区域，供页面获取
        req.setAttribute("catalog", catalog);

        //加载学科信息
        List<Course> all = courseService.findAll();
        req.setAttribute("courseList", all);

        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/catalog/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从请求中封装数据显示到页面中
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.update(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从请求中封装数据显示到页面中
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.delete(catalog);
        resp.sendRedirect(req.getContextPath() + "/store/catalog?operation=list");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
