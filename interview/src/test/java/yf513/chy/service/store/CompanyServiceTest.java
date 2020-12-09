package yf513.chy.service.store;

import com.github.pagehelper.PageInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yf513.chy.domain.store.Company;
import yf513.chy.service.store.impl.CompanyServiceImpl;

/**
 * @author CHY
 * @date 2020/11/23 16:16
 */
public class CompanyServiceTest {
    private CompanyService companyService = null;

    @Before
    public void init() {
        companyService = new CompanyServiceImpl();
    }

    @Test
    public void testSave() {
        Company company = new Company();
        company.setName("测试数据");
        companyService.save(company);
    }

    @Test
    public void testFindAll() {
        PageInfo all = companyService.findAll(1, 100);
        System.out.println(all);
    }

    @After
    public void destroy() {
        companyService = null;
    }
}
