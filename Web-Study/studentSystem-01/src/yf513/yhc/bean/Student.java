package yf513.yhc.bean;

/**
 * @author CHY
 * @date 2020/11/9 10:31
 */
public class Student {
    private String username;
    private int age;
    private int grade;

    public Student() {
    }

    public Student(String username, int age, int grade) {
        this.username = username;
        this.age = age;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
