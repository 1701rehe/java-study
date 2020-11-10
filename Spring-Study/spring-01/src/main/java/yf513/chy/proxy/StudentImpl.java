package yf513.chy.proxy;

/**
 * @author CHY
 * @date 2020/9/18 20:42
 */
public class StudentImpl implements StudentDAO {
    @Override
    public boolean login(int id, String name) {

        System.out.println("this is-->" + id + " " + name);
        return true;
    }
}
