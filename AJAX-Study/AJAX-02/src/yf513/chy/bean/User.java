package yf513.chy.bean;

/*
    用户的实体类
 */
public class User {
    private Integer id;     // 主键id
    private String name;    // 姓名
    private Integer age;    // 年龄
    private Integer search_count;    // 搜索数量

    public User() {
    }

    public User(Integer id, String name, Integer age, Integer search_count) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.search_count = search_count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSearch_count() {
        return search_count;
    }

    public void setSearch_count(Integer search_count) {
        this.search_count = search_count;
    }
}
