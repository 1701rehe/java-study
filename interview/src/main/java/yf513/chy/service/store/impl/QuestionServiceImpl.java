package yf513.chy.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import yf513.chy.dao.store.QuestionDao;
import yf513.chy.domain.store.Question;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.store.QuestionService;
import yf513.chy.utils.TransactionUtil;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/11/26 11:17
 */
public class QuestionServiceImpl implements QuestionService {
    @Override
    public void update(Question question, boolean flag) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            if (flag) {
                question.setPicture(question.getId());
            }
            //3.调用Dao层操作
            questionDao.update(question);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String save(Question question, boolean flag) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //id使用UUID的生成策略来获取
            String id = UUID.randomUUID().toString();
            question.setId(id);
            //设置新创建的题目默认的审核状态为未审核（0）
            question.setReviewStatus("0");
            question.setCreateTime(new Date());
            //检测到前段上传文件了，则记录文件名，否则不记录
            if (flag) {
                //设置当前存储的图片名称为id值，保证唯一不会重复
                question.setPicture(id);
            }

            //3.调用Dao层操作
            questionDao.save(question);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
            return id;
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Question question) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //3.调用Dao层操作
            questionDao.delete(question);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Question findById(String id) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //3.调用Dao层操作
            return questionDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Question> findAll() {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //3.调用Dao层操作
            return questionDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //3.调用Dao层操作
            PageHelper.startPage(page, size);  //分页插件的使用
            List<Question> all = questionDao.findAll();
            PageInfo pageInfo = new PageInfo(all);
            return pageInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ByteArrayOutputStream getReport() throws IOException {
        //获取对应的数据
        SqlSession sqlSession = null;
        List<Question> questionList = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            QuestionDao questionDao = MapperFactory.getMapper(sqlSession, QuestionDao.class);
            //3.调用Dao层操作
            questionList = questionDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //1.获取到对应的Excel文件，工作簿文件
        Workbook wb = new XSSFWorkbook();
        //2.创建工作表
        Sheet sheet = wb.createSheet("数据文件");

        //设置通用配置
        CellStyle cs_field = wb.createCellStyle();
        cs_field.setAlignment(HorizontalAlignment.CENTER);
        cs_field.setVerticalAlignment(VerticalAlignment.CENTER);
        cs_field.setBorderTop(BorderStyle.THIN);
        cs_field.setBorderBottom(BorderStyle.THIN);
        cs_field.setBorderLeft(BorderStyle.THIN);
        cs_field.setBorderRight(BorderStyle.THIN);

        //合并单元格是使用sheet对象  一般放在制作数据前面
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 12));
        //制作标题
        Row row_1 = sheet.createRow(1);
        Cell cell_1_1 = row_1.createCell(1);  //cell命名规范 cell+行+列
        cell_1_1.setCellValue("在线试题导出信息");

        //创建一个样式 通过工作簿文件获取
        CellStyle cs = wb.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        cell_1_1.setCellStyle(cs);
        //制作表头
        String[] fields = {"题目ID", "所属公司ID", "所属目录ID", "题目简介", "题干描述", "题干配图", "题目分析",
                "题目类型", "题目难度", "是否经典题", "题目状态", "审核状态"};
        Row row_2 = sheet.createRow(2);
        for (int i = 0; i < fields.length; i++) {
            Cell cell_2_temp = row_2.createCell(1 + i);
            cell_2_temp.setCellValue(fields[i]);

            cell_2_temp.setCellStyle(cs_field);
        }

        //制作数据区
        int row_index = 0;
        for (Question question : questionList) {
            Row row_temp = sheet.createRow(3 + row_index++);
            int cell_index = 0;
            Cell cell_data_1 = row_temp.createCell(1 + cell_index++);
            cell_data_1.setCellValue(question.getId());
            cell_data_1.setCellStyle(cs_field);

            Cell cell_data_2 = row_temp.createCell(1 + cell_index++);
            cell_data_2.setCellValue(question.getCompanyId());
            cell_data_2.setCellStyle(cs_field);

            Cell cell_data_3 = row_temp.createCell(1 + cell_index++);
            cell_data_3.setCellValue(question.getCatalogId());
            cell_data_3.setCellStyle(cs_field);

            Cell cell_data_4 = row_temp.createCell(1 + cell_index++);
            cell_data_4.setCellValue(question.getRemark());
            cell_data_4.setCellStyle(cs_field);

            Cell cell_data_5 = row_temp.createCell(1 + cell_index++);
            cell_data_5.setCellValue(question.getSubject());
            cell_data_5.setCellStyle(cs_field);

            Cell cell_data_6 = row_temp.createCell(1 + cell_index++);
            cell_data_6.setCellValue(question.getPicture());
            cell_data_6.setCellStyle(cs_field);

            Cell cell_data_7 = row_temp.createCell(1 + cell_index++);
            cell_data_7.setCellValue(question.getAnalysis());
            cell_data_7.setCellStyle(cs_field);

            Cell cell_data_8 = row_temp.createCell(1 + cell_index++);
            cell_data_8.setCellValue(question.getType());
            cell_data_8.setCellStyle(cs_field);

            Cell cell_data_9 = row_temp.createCell(1 + cell_index++);
            cell_data_9.setCellValue(question.getDifficulty());
            cell_data_9.setCellStyle(cs_field);

            Cell cell_data_10 = row_temp.createCell(1 + cell_index++);
            cell_data_10.setCellValue(question.getIsClassic());
            cell_data_10.setCellStyle(cs_field);

            Cell cell_data_11 = row_temp.createCell(1 + cell_index++);
            cell_data_11.setCellValue(question.getState());
            cell_data_11.setCellStyle(cs_field);

            Cell cell_data_12 = row_temp.createCell(1 + cell_index++);
            cell_data_12.setCellValue(question.getReviewStatus());
            cell_data_12.setCellStyle(cs_field);
        }


        //输出时通过流的形式对外输出，包装对应的目标文件
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //将内存中的workbook数据写入到流中
        wb.write(os);
        wb.close();
        return os;
    }
}
