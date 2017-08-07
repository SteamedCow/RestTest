package test.lasse.resttest.model;

import java.util.Arrays;

/**
 * Created by Lasse on 07-Aug-17.
 */

public class User {
    private Integer id;
    private String name, email;
    private int age;
    private String[] topics;

    public User(String name, String email, int age, String[] topics) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.topics = topics;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String[] getTopics() {
        return topics;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", topics=" + Arrays.toString(topics) +
                '}';
    }
}
