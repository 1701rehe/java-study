package yf513.chy.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/*
 * Jedis工具类
 */
public class JedisUtils {

    private static JedisPoolConfig poolConfig = null;
    private static JedisPool jedisPool = null;
    private static Integer maxTotal = null;
    private static Integer maxIdle = null;
    private static String host = null;
    private static Integer port = null;

    //定义读取配置文件的对象
    private static ResourceBundle rb;

    /*
     * 使用静态代码块初始化Redis连接池
     */
    static {
        //实例化ResourceBundle对象
        rb = ResourceBundle.getBundle("redis");
        //读取配置文件 获得参数值
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
        port = Integer.parseInt(rb.getString("redis.port"));
        host = rb.getString("redis.host");
        poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        //创建连接池对象--poolConfig，主机地址，端口号
        jedisPool = new JedisPool(poolConfig, host, port);
    }

    /**
     * 获取Jedis对象
     *
     * @return
     */
    public static Jedis getResource() {
        return jedisPool.getResource();
    }
}
