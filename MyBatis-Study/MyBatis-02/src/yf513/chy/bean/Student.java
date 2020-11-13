package yf513.chy.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CHY
 * @date 2020/11/13 21:20
 */
public class Student {
    private Integer sid;
    private String name;
    private Integer age;
    private Date birthday;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age, Date birthday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Integer getId() {
        return sid;
    }

    public void setId(Integer sid) {
        this.sid = sid;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid = " + sid +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", birthday = " + new SimpleDateFormat("yyyy-MM-dd").format(birthday) +
                '}';
    }
}