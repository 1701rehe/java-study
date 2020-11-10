package yf513.chy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yf513.chy.lifeInit.Categroy;
import yf513.chy.proxy.StudentDAO;
import yf513.chy.proxy.StudentJDKProxy;
import yf513.chy.proxy.StudentProxy;

public class TestAspect {
    private ApplicationContext ctx;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }


    @Test
    public void BeanInitTest1(){
        Categroy c = ctx.getBean("c1", Categroy.class);
        System.out.println(c);
    }


    @Test
    public void BeanInitTest2(){
        Categroy c = ctx.getBean("c2", Categroy.class);
        System.out.println(c);
    }


    //bean生命周期测试(创建--初始化--销毁)
    @Test
   public void BeanPostProcessorTest(){
       Categroy c = ctx.getBean("c3", Categroy.class);
       System.out.println(c);
   }


    @Test
    public void staticProxyTest(){
        StudentDAO studentDAO = new StudentProxy();
        studentDAO.login(10,"chy");
    }

    @Test
    public void dynamicProxyTest1(){
        StudentDAO student = ctx.getBean("proxy", StudentDAO.class);
        student.login(10,"chy");
    }

    @Test
    public void dynamicProxyTest2(){
        StudentDAO student = ctx.getBean("student2", StudentDAO.class);
        student.login(10,"chy");
    }

    @Test
    public void JDKProxyTest2(){
        StudentJDKProxy proxy = ctx.getBean("jdkProxy", StudentJDKProxy.class);
        StudentDAO studentDAO = (StudentDAO)proxy.createProxy();
        studentDAO.login(10,"qqq");
    }
}
