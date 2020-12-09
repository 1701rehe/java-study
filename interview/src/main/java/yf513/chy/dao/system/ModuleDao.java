package yf513.chy.dao.system;

import yf513.chy.domain.system.Module;

import java.util.List;
import java.util.Map;

/**
 * @author CHY
 * @date 2020/12/2 15:05
 */
public interface ModuleDao {
    int delete(Module module);

    int update(Module Module);

    int save(Module Module);

    Module findById(String id);

    List<Module> findAll();

    List<Map> findAuthorDataByRoleId(String roleId);

    List<Module> findModuleByUserId(String uid);

}
