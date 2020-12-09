package yf513.chy.web.controller.store;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import yf513.chy.domain.store.Catalog;
import yf513.chy.domain.store.Company;
import yf513.chy.domain.store.Question;
import yf513.chy.utils.BeanUtil;
import yf513.chy.web.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/26 11:26
 */
@WebServlet("/store/question")
public class QuestionServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if ("list".equals(operation)) {
            this.list(req, resp);
        } else if ("toAdd".equals(operation)) {
            this.toAdd(req, resp);
        } else if ("save".equals(operation)) {
            try {
                this.save(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("toEdit".equals(operation)) {
            this.toEdit(req, resp);
        } else if ("edit".equals(operation)) {
            try {
                this.edit(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("delete".equals(operation)) {
            this.delete(req, resp);
        } else if ("toTestUpload".equals(operation)) {
            this.toTestUpload(req, resp);
        } else if ("testUpload".equals(operation)) {
            try {
                this.testUpload(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("downloadReport".equals(operation)) {
            this.downloadReport(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置分页参数
        int page = 1;
        int size = 10;
        if (StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        PageInfo all = questionService.findAll(page, size);
        //将数据保存到指定的位置
        req.setAttribute("page", all);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/pages/store/question/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载所有的企业信息放入到companyList
        List<Company> companyList = companyService.findAll();
        req.setAttribute("companyList", companyList);
        //加载所有的目录信息放入到catalogList
        List<Catalog> catalogList = catalogService.findAll();
        req.setAttribute("catalogList", catalogList);
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/pages/store/question/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.确认该操作是否支持文件长传操作 --> enctype="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(req)) {
            //2.创建磁盘工厂对象，用来操作磁盘
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //3.Servlet文件上传核心对象 --> 操作文件上传的操作
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //4.从请求中抽取对应的数据
            List<FileItem> fileItems = fileUpload.parseRequest(req);

            //创建一个标记位，标记当前是否有文件上传
            boolean flag = false;
            for (FileItem fileItem : fileItems) {
                if (StringUtils.isNotBlank(fileItem.getName())) {
                    //能进入说明有文件上传
                    flag = true;
                    break;
                }
            }
            //处理form表单提交过来的非文件数据
            Question question = BeanUtil.fillBean(fileItems, Question.class);
            String picture = questionService.save(question, flag);
            for (FileItem fileItem : fileItems) {
                //处理form表单提交过来的文件数据
                if (!fileItem.isFormField()) {
                    //从临时存储文件的地方将内容写入到指定位置
                    fileItem.write(new File(this.getServletContext().getRealPath("upload"), picture));
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询要修改的数据findById
        String id = req.getParameter("id");
        Question question = questionService.findById(id);
        //将数据加载到指定区域，供页面获取
        req.setAttribute("question", question);

        //加载所有的企业信息放入到companyList
        List<Company> companyList = companyService.findAll();
        req.setAttribute("companyList", companyList);
        //加载所有的目录信息放入到catalogList
        List<Catalog> catalogList = catalogService.findAll();
        req.setAttribute("catalogList", catalogList);
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/pages/store/question/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.确认该操作是否支持文件长传操作 --> enctype="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(req)) {
            //2.创建磁盘工厂对象，用来操作磁盘
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //3.Servlet文件上传核心对象 --> 操作文件上传的操作
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //4.从请求中抽取对应的数据
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            //创建一个标记位，标记当前是否有文件上传
            boolean flag = false;
            for (FileItem fileItem : fileItems) {
                if (StringUtils.isNotBlank(fileItem.getName())) {
                    //能进入说明有文件上传
                    flag = true;
                    break;
                }
            }
            //处理form表单提交过来的非文件数据
            Question question = BeanUtil.fillBean(fileItems, Question.class);
            questionService.update(question, flag);
            for (FileItem fileItem : fileItems) {
                //处理form表单提交过来的文件数据
                if (!fileItem.isFormField()) {
                    //从临时存储文件的地方将内容写入到指定位置
                    fileItem.write(new File(this.getServletContext().getRealPath("upload"), question.getId()));
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Question question = BeanUtil.fillBean(req, Question.class, "yyyy-MM-dd");
        questionService.delete(question);
        resp.sendRedirect(req.getContextPath() + "/store/question?operation=list");
    }

    private void toTestUpload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/store/question/testFileUpload.jsp").forward(req, resp);
    }

    private void testUpload(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.确认该操作是否支持文件长传操作 --> enctype="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(req)) {
            //2.创建磁盘工厂对象，用来操作磁盘
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //3.Servlet文件上传核心对象 --> 操作文件上传的操作
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //4.从请求中抽取对应的数据
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                //判断当前表单是否是文件表单,只对文件表单操作
                // fileItem.isFormField() true 当前的字段是非文件字段 false 当前是文件字段
                if (!fileItem.isFormField()) {
                    //从临时存储文件的地方将内容写入到指定位置
                    fileItem.write(new File(this.getServletContext().getRealPath("upload"), fileItem.getName()));
                }
            }
        }
    }

    private void downloadReport(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置返回的数据类型
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
        resp.addHeader("Content-Disposition", "attachment;fileName=data.xlsx");
        ByteArrayOutputStream os = questionService.getReport();
        //获取产生响应的流对象
        ServletOutputStream sos = resp.getOutputStream();
        //将数据从原始的字节流对象中提取出来，写入到servlet对应的输出流中
        os.writeTo(sos);
        sos.flush();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
