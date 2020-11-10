package yf513.chy.lifeInit;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author CHY
 * @date 2020/9/18 16:56
 */
@Data
public class Categroy implements InitializingBean{
    private int id;
    private String name;

//    public void init(){
//        setName("lmy");
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is InitializingBean");
        setName("lmy");
    }
}
