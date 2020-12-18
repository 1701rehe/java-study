package yf513.chy.service;

/**
 * @author CHY
 * @date 2020/12/17 15:03
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yf513.chy.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() throws ParseException {
        User user = new User();
        user.setUserName("chy");
        user.setPassword("123");
        user.setRealName("hongYu");
        user.setGender(1);
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1995-03-21"));

        userService.save(user);
    }

}
