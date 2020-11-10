package com.cqupt.config;

import com.cqupt.dao.UserDAO;
import com.cqupt.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CHY
 * @date 2020/9/22 14:13
 */
@Configuration
public class Myconfig {

    @Bean
    public User user(){
        return new User();
    }

}
