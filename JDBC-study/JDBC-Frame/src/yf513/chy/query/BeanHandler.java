package yf513.chy.query;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author CHY
 * @date 2020/11/13 17:01
 */
public class BeanHandler<T> implements ResultSetHandler{
    //1.声明对象类型变量
    private Class<T> beanClass;

    //2.有参构造对变量赋值
    public BeanHandler(Class<T> beanClass) {
        this.beanClass = beanClass;
    }

    /*
        将ResultSet结果集中的数据封装到beanClass类型对象中
     */
    @Override
    public T handler(ResultSet rs) {
        //3.声明对象
        T bean = null;
        try{
            //4.创建传递参数的对象
            bean = beanClass.newInstance();

            //5.判断是否有结果集
            if(rs.next()) {
                //6.得到所有的列名
                //6.1先得到结果集的源信息
                ResultSetMetaData rsmd = rs.getMetaData();
                //6.2还要得到有多少列
                int columnCount = rsmd.getColumnCount();
                //6.3遍历列数
                for(int i = 1; i <= columnCount; i++) {
                    //6.4得到每列的列名
                    String columnName = rsmd.getColumnName(i);
                    //6.5通过列名获取数据
                    Object columnValue = rs.getObject(columnName);

                    //6.6列名其实就是对象中成员变量的名称。于是就可以使用列名得到对象中属性的描述器(get和set方法)
                    PropertyDescriptor pd = new PropertyDescriptor(columnName.toLowerCase(),beanClass);
                    //6.7获取set方法
                    Method writeMethod = pd.getWriteMethod();
                    //6.8执行set方法，给成员变量赋值
                    writeMethod.invoke(bean,columnValue);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //7.将对象返回
        return bean;
    }
}
