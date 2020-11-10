package yf513.yhc.bean;

import java.util.PrimitiveIterator;

/**
 * @author CHY
 * @date 2020/11/7 11:33
 */
public class Student {
    private String name;
    private String age;
    private String grade;

    public Student(){

    }

    public Student(String name, String age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
