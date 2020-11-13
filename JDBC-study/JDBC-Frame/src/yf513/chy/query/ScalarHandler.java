package yf513.chy.query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author CHY
 * @date 2020/11/13 17:02
 * 用于返回一个聚合函数的查询结果
 */
public class ScalarHandler<T> implements ResultSetHandler {
    @Override
    public Long handler(ResultSet rs) {
        //1.声明一个变量
        Long value = null;
        try{
            //2.判断是否有结果
            if(rs.next()) {
                //3.获取结果集的源信息
                ResultSetMetaData rsmd = rs.getMetaData();
                //4.获取第一列的列名
                String columnName = rsmd.getColumnName(1);
                //5.根据列名获取值
                value = rs.getLong(columnName);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        //6.将结果返回
        return value;
    }
}
