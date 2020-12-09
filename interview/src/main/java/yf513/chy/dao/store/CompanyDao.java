package yf513.chy.dao.store;

import yf513.chy.domain.store.Company;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/23 15:23
 */
public interface CompanyDao {
    int save(Company company);

    int delete(Company company);

    int update(Company company);

    Company findById(String id);

    List<Company> findAll();
}
