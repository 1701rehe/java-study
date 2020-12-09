package yf513.chy.service.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import yf513.chy.domain.system.Role;
import yf513.chy.domain.system.User;
import yf513.chy.service.system.impl.RoleServiceImpl;

import java.io.IOException;
import java.util.List;


/**
 * @author CHY
 * @date 2020/12/2 14:32
 */
public class RoleServiceTest {
    private RoleService roleService = null;

    @Before
    public void init() {
        roleService = new RoleServiceImpl();
    }

    @Test
    public void testFindAll() {
        PageInfo all = roleService.findAll(1, 100);
        System.out.println(all);
    }
}
