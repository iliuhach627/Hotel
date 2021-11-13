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

    @Override
    public String toString() {
        return String.format("\nGuest:" +
                        "\r\n\tname: %s" +
                        "\r\n\tsurName: %s" +
                        "\r\n\ttel: %s" +
                        "\r\n\tage: %d" +
                        "\r\n\tprice: %d" +
                        "\r\n\tgender: %s",
                name(),surName,tel,age,gender);
    }

}
