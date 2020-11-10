package yf513.chy.domain;

import lombok.Data;

import java.util.List;

/**
 * @author CHY
 */
@Data
public class User {
    private  int id;
    private String name;
    private int age;
    private String email;

    private List<Account> accounts;
}
