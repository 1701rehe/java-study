package yf513.chy.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import yf513.chy.dao.system.RoleDao;
import yf513.chy.dao.system.UserDao;
import yf513.chy.domain.system.Role;
import yf513.chy.factory.MapperFactory;
import yf513.chy.service.system.RoleService;
import yf513.chy.utils.TransactionUtil;

import java.util.List;
import java.util.UUID;

/**
 * @author CHY
 * @date 2020/12/2 11:24
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public void save(Role role) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            String id = UUID.randomUUID().toString();
            role.setId(id);
            roleDao.save(role);
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
    public void delete(Role role) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            roleDao.delete(role);
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
    public void update(Role role) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            roleDao.update(role);
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
    public Role findById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            return roleDao.findById(id);
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
    public List<Role> findAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            return roleDao.findAll();
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
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            PageHelper.startPage(page, size);
            List<Role> all = roleDao.findAll();
            PageInfo pageInfo = new PageInfo(all);
            return pageInfo;
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
    public void updateRoleModule(String roleId, String moduleIds) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            //修改关系表中的数据
            //--现有的关系全部取消掉
            roleDao.deleteRoleModule(roleId);
            //--建立新的关系
            if (StringUtils.isNotBlank(moduleIds)) {
                String[] mId = moduleIds.split(",");
                for (String moduleId : mId) {
                    roleDao.saveRoleModule(roleId, moduleId);
                }
            }
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
    public List<Role> findAllRoleByUserId(String userId) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            RoleDao roleDao = MapperFactory.getMapper(sqlSession, RoleDao.class);
            //3.调用Dao层操作
            return roleDao.findAllRoleByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
