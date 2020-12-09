package yf513.chy.dao.system;

import org.apache.ibatis.annotations.Param;
import yf513.chy.domain.system.Role;

import java.util.List;

/**
 * @author CHY
 * @date 2020/11/30 16:50
 */
public interface RoleDao {
    int delete(Role role);

    int update(Role role);

    int save(Role role);

    Role findById(String id);

    List<Role> findAll();

    void deleteRoleModule(String roleId);

    void saveRoleModule(@Param("roleId") String roleId, @Param("moduleId") String moduleId);

    List<Role> findAllRoleByUserId(String userId);
}
