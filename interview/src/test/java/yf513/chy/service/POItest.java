package yf513.chy.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import yf513.chy.domain.store.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CHY
 * @date 2020/11/28 11:02
 */
public class POItest {

    @Test
    public void testWriteByPoi() throws IOException {
        //1.获取到对应的Excel文件，工作簿文件
        Workbook wb = new XSSFWorkbook();
        //2.创建工作表
        Sheet sheet = wb.createSheet();
        wb.createSheet("这是啥呀");

        //3.创建工作表中的行对象
        Row row = sheet.createRow(1);
        //4.创建工作表中行中的列对象
        Cell cell = row.createCell(1);
        //5.在列中写数据
        cell.setCellValue("测试一下单元格");

        //创建一个文件对象，作为excel文件内容的输出文件
        File f = new File("test.xlsx");
        //输出时通过流的形式对外输出，包装对应的目标文件
        OutputStream os = new FileOutputStream(f);
        //将内存中的workbook数据写入到流中
        wb.write(os);
        wb.close();
        os.close();
    }

    @Test
    public void testReadByPoi() throws IOException {
        //1.获取要读取的文件工作簿对象
        Workbook wb = new XSSFWorkbook("test.xlsx");
        //2.获取工作表
        Sheet s = wb.getSheetAt(0);
        //3.获取行
        Row row = s.getRow(1);
        //4.获取列
        Cell cell = row.getCell(1);
        //5.根据数据的类型获取数据
//                String data = cell.getStringCellValue();
        double data = cell.getNumericCellValue();
//        boolean data = cell.getBooleanCellValue();

        System.out.println(data);

        wb.close();
    }

    @Test
    public void testProjectPOI() throws IOException {
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
        List<Question> questionList = null;
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

        //创建一个文件对象，作为excel文件内容的输出文件
        File f = new File("test.xlsx");
        //输出时通过流的形式对外输出，包装对应的目标文件
        OutputStream os = new FileOutputStream(f);
        //将内存中的workbook数据写入到流中
        wb.write(os);
        wb.close();
        os.close();
    }
}
