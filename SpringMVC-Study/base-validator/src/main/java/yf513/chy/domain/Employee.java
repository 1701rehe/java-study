package yf513.chy.domain;

import javax.validation.constraints.NotNull;

/**
 * @author CHY
 * @date 2020/12/17 9:42
 */
public class Employee {

    @NotNull(message = "姓名不能为空")
    private String name;

    private Integer age;

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
}
