package yf513.chy.jacksonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.*;

/**
 * @author CHY
 * @date 2020/11/18 15:49
 */
public class ObjectMapperTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test01() throws Exception {
        User user = new User("小陈", 25);
        String userJSON = mapper.writeValueAsString(user);
        System.out.println("json字符串: " + userJSON);

        User userJAVA = mapper.readValue(userJSON, User.class);
        System.out.println("java对象: " + userJAVA);
    }

    @Test
    public void test02() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("姓名", "小陈");
        map.put("性别", "男");
        String mapJSON = mapper.writeValueAsString(map);
        System.out.println("json字符串: " + mapJSON);
        HashMap<String, String> mapJAVA = mapper.readValue(mapJSON, HashMap.class);
        System.out.println("map对象: " + mapJAVA);
    }

    @Test
    public void test03() throws Exception {
        Map<String, User> map = new HashMap<>();
        map.put("重邮", new User("小陈", 25));
        map.put("工商", new User("小卢", 24));
        String mapJSON = mapper.writeValueAsString(map);
        System.out.println("json字符串: " + mapJSON);
        HashMap<String, User> mapJAVA = mapper.readValue(mapJSON, new TypeReference<HashMap<String, User>>() {
        });
        System.out.println("map对象: " + mapJAVA);
    }

    @Test
    public void test04() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("小陈");
        list.add("小卢");
        String listJSON = mapper.writeValueAsString(list);
        System.out.println("json字符串: " + listJSON);
        List<String> listJAVA = mapper.readValue(listJSON, ArrayList.class);
        System.out.println("list对象: " + listJAVA);
    }

    @Test
    public void test05() throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("小陈", 25));
        list.add(new User("小卢", 24));
        String listJSON = mapper.writeValueAsString(list);
        System.out.println("json字符串: " + listJSON);
        List<String> listJAVA = mapper.readValue(listJSON, new TypeReference<List<User>>(){});
        System.out.println("list对象: " + listJAVA);
    }
}
