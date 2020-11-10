package yf513.chy;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author CHY
 * @date 2020/10/28 16:34
 */
public class JedisUtils {
    private static int maxTotal;
    private static int maxIdle;
    private static String host;
    private static int port;
    private static String password;
    private static JedisPoolConfig jpc;
    private static JedisPool jp;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        maxTotal = Integer.parseInt(bundle.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(bundle.getString("redis.maxIdle"));
        host = bundle.getString("redis.host");
        port = Integer.parseInt(bundle.getString("redis.port"));
        password = bundle.getString("redis.password");
        //jedis连接池
        jpc = new JedisPoolConfig();
        jpc.setMaxTotal(maxTotal);
        jpc.setMaxIdle(maxIdle);
        jp = new JedisPool(jpc, host, port, 0, password);
    }

    public static Jedis getJedis() {

//        String host="192.168.153.129";
//        int port =6379;
        return jp.getResource();
    }

    public static void close() {
        jp.close();
    }
}
