package yf513.chy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author CHY
 * @date 2020/12/18 15:23
 */
@Configuration
//等同于<context:component-scan base-package="yf513.chy.controller"/>
@ComponentScan("yf513.chy.controller")
//等同于<mvc:annotation-driven/>，还不完全相同
@EnableWebMvc
public class SpringMvcConfig {
}
