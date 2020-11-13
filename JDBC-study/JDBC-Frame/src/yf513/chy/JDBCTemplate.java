package yf513.chy;

import yf513.chy.query.ResultSetHandler;
import yf513.chy.utils.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author CHY
 * @date 2020/11/13 16:00
 */
public class JDBCTemplate {
    //定义参数变量
    private DataSource dataSource;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Long queryForScalar(String sql, ResultSetHandler<Long> rsh, Object... objs) {
        Long result = null;
        try {
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);

            //获取sql语句中的参数源信息
            ParameterMetaData pData = pst.getParameterMetaData();
            int parameterCount = pData.getParameterCount();

            //判断参数个数是否一致
            if (parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句中的?占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i + 1, objs[i]);
            }

            //执行sql语句
            rs = pst.executeQuery();

            //通过ScalarHandler方式对结果进行处理
            result = rsh.handler(rs);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DataSourceUtils.close(con, pst, rs);
        }

        //将结果返回
        return result;
    }

    //定义update方法
    public int update(String sql, Object... objs) {
        int result = 0;
        try {
            con = dataSource.getConnection();
            pst = con.prepareStatement(sql);
            //通过执行者对象获取参数的源信息对象
            ParameterMetaData parameterMetaData = pst.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();

            //判断参数数量是否一致
            if (parameterCount != objs.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句占位符赋值
            for (int i = 0; i < objs.length; i++) {
                pst.setObject(i + 1, objs[i]);
            }

            //执行sql语句
            result = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtils.close(con, pst);
        }
        return result;
    }
}
