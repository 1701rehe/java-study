package yf513.chy;

import org.junit.Test;
import yf513.chy.utils.DataSourceUtils;

/**
 * @author CHY
 * @date 2020/11/13 16:18
 * 模拟dao层
 */
public class JDBCTemplateTest {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    @Test
    public void insert() {
        Object[] params = {6, "陈虹羽", 25, "1995-03-21"};
        int result = jdbcTemplate.update("insert into student values(?,?,?,?)", params);
        if (result != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void update() {
        Object[] params = {"小陈", 6};
        int result = jdbcTemplate.update("update student set name = ? where sid =?", params);
        if (result != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void delete() {
        Object[] params = {6};
        int result = jdbcTemplate.update("delete from student where sid =?", params);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
