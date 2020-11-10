package yf513.chy.lifeInit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author CHY
 * @date 2020/9/18 16:58
 */

/**
 * 初始化方法 1.实现InitializingBean
 *          2.在实现类中创建方法 -->配置inti-method
 *
 * 销毁方法：1.实现DisposableBean
 *         2.在实习类中创建方法  -->配置destroy-method
 *
 * 在实现InitializingBean之前执行，在自定义初始方法之后执行的BeanPostProcessor接口
 */
public class MyBeanProcessor implements BeanPostProcessor {
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Categroy){
            Categroy categroy = (Categroy) bean;
            categroy.setName("小王八");
        }


        return bean;

    }
}
