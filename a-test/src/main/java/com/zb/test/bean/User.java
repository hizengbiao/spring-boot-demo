package com.zb.test.bean;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
public class User {
    private String name;
    private int age;
    private Address address;

    public User(){

    }

    public User(@Nullable String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
