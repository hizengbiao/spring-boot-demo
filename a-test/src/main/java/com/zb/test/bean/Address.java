package com.zb.test.bean;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String country;

    public Address(){

    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
}
