package yf513.chy.dao.store;

import yf513.chy.domain.store.Catalog;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/26 9:20
 */
public interface CatalogDao {
    int save(Catalog catalog);

    int delete(Catalog catalog);

    int update(Catalog catalog);

    Catalog findById(String id);

    List<Catalog> findAll();
}
