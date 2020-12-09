package yf513.chy.web.controller.store;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.store.Company;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CHY
 * 一个servlet只能完成一种功能，但是请求页面只有一个为了完成多种功能的请求，必须加上标记
 * /store/company拼接上不同的方法名
 * @date 2020/11/23 16:46
 */
@WebServlet("/store/company")
public class CompanyServlet extends BaseServlet {
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

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据封装
        Company company = BeanUtil.fillBean(req, Company.class);
        //调用业务层接口
        //CompanyService companyService = new CompanyServiceImpl();
        companyService.delete(company);
        //页面跳转
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        //CompanyService companyService = new CompanyServiceImpl();
        Company company = companyService.findById(id);
        //将数据加载到指定区域
        req.setAttribute("company", company);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/company/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据封装
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        //调用业务层接口
        //CompanyService companyService = new CompanyServiceImpl();
        companyService.update(company);
        //页面跳转
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");
    }


    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进入列表页
        //获取数据
        //CompanyService companyService = new CompanyServiceImpl();
        int page = 1;
        int size = 5;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = companyService.findAll(page, size);
        //将数据保存到指定的位置
        req.setAttribute("page", all);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/company/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //将数据获取到，封装成一个对象
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        //调用业务层接口save
        //CompanyService companyService = new CompanyServiceImpl();
        companyService.save(company);
        //跳转回页面list
        resp.sendRedirect(req.getContextPath() + "/store/company?operation=list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
