package yf513.chy.web.controller;

import yf513.chy.service.store.*;
import yf513.chy.service.store.impl.*;
import yf513.chy.service.system.DeptService;
import yf513.chy.service.system.ModuleService;
import yf513.chy.service.system.RoleService;
import yf513.chy.service.system.UserService;
import yf513.chy.service.system.impl.DeptServiceImpl;
import yf513.chy.service.system.impl.ModuleServiceImpl;
import yf513.chy.service.system.impl.RoleServiceImpl;
import yf513.chy.service.system.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author CHY
 * @date 2020/11/23 20:40
 */
public class BaseServlet extends HttpServlet {
    protected CompanyService companyService;
    protected DeptService deptService;
    protected UserService userService;
    protected CourseService courseService;
    protected CatalogService catalogService;
    protected QuestionService questionService;
    protected QuestionItemService questionItemService;
    protected RoleService roleService;
    protected ModuleService moduleService;

    @Override
    public void init() throws ServletException {
        companyService = new CompanyServiceImpl();
        deptService = new DeptServiceImpl();
        userService = new UserServiceImpl();
        courseService = new CourseServiceImpl();
        catalogService = new CatalogServiceImpl();
        questionService = new QuestionServiceImpl();
        questionItemService = new QuestionItemServiceImpl();
        roleService = new RoleServiceImpl();
        moduleService = new ModuleServiceImpl();
    }
}
