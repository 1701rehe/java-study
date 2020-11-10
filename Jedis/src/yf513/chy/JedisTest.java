package yf513.chy;

import redis.clients.jedis.Jedis;

/**
 * @author CHY
 * @date 2020/10/28 14:28
 */
public class JedisTest {
    public static void main(String[] args) {
        //获取连接对象
//        Jedis jedis = new Jedis("192.168.153.129", 6379);
        Jedis jedis =JedisUtils.getJedis();
        //执行操作
//        jedis.set("age","25");
        String location = jedis.get("name");
        System.out.println(location);
        //关闭连接
        jedis.close();
        JedisUtils.close();
    }
}
