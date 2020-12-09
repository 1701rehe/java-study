package yf513.chy.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.system.ModuleDao;
import yf513.chy.dao.system.RoleDao;
import yf513.chy.domain.system.Module;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.system.ModuleService;
import yf513.chy.utils.TransactionUtil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/12/2 15:11
 */
public class ModuleServiceImpl implements ModuleService {
    @Override
    public void save(Module module) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            String id = UUID.randomUUID().toString();
            module.setId(id);
            moduleDao.save(module);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Module module) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            moduleDao.delete(module);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Module module) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            moduleDao.update(module);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Module findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            return moduleDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Module> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            return moduleDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            PageHelper.startPage(page, size);
            List<Module> all = moduleDao.findAll();
            PageInfo pageInfo = new PageInfo(all);
            return pageInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Map> findAuthorDataByRoleId(String roleId) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            ModuleDao moduleDao = MapperFactory.getMapper(sqlSession, ModuleDao.class);
            return moduleDao.findAuthorDataByRoleId(roleId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
