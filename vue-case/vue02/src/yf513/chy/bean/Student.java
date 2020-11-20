package yf513.chy.bean;

import java.sql.Date;

/*
    学生实体类
 */
public class Student {
    private String number;  //学号
    private String name;    //姓名
    private Date birthday;  //生日
    private String address; //地址

    public Student() {
    }

    public Student(String number, String name, Date birthday, String address) {
        this.number = number;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
