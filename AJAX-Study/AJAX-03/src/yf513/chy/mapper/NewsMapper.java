package yf513.chy.mapper;

import org.apache.ibatis.annotations.Select;
import yf513.chy.bean.News;

import java.util.List;

public interface NewsMapper {
    /*
        查询全部
     */
    @Select("SELECT * FROM news")
    public abstract List<News> selectAll();
}
