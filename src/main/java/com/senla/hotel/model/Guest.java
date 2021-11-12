package com.senla.hotel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guest extends BaseEntity{
    private String name;
    private String surName;
    private String tel;
    private int age;
    private String gender;

    private Guest(String name,String surname,String tel,int age,String gender){
        this.name=name;
        this.surName=surname;
        this.tel=tel;
        this.age=age;
        this.gender=gender;
    }
}
