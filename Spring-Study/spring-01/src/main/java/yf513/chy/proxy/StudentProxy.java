package yf513.chy.proxy;

/**
 * @author CHY
 * @date 2020/9/18 20:43
 */
public class StudentProxy implements StudentDAO {
    //代理类有原始对象
    private StudentImpl studentImpl = new StudentImpl();

    @Override
    public boolean login(int id, String name) {
        System.out.println("----静态代理----");
        studentImpl.login(id,name);
        return true;
    }
}
