package yf513.chy.dao.system;


import yf513.chy.domain.system.Dept;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/23 21:06
 */
public interface DeptDao {
    int save(Dept dept);

    int delete(Dept dept);

    int update(Dept dept);

    Dept findById(String id);

    List<Dept> findAll();
}
