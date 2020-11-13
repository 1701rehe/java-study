package yf513.chy.query;

import java.sql.ResultSet;

/**
 * @author CHY
 * @date 2020/11/13 17:00
 */
public interface ResultSetHandler<T> {
    //处理结果集的抽象方法。
    <T> T handler(ResultSet rs);
}
