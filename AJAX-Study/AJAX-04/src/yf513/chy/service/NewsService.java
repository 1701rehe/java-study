package yf513.chy.service;

import com.github.pagehelper.Page;

public interface NewsService {
    /*
        分页查询
     */
    public abstract Page pageQuery(Integer start, Integer pageSize);
}
