package com.senla.hotel.model;

import lombok.Data;

@Data
public class Guest extends BaseEntity{
    private String name;
    private String surName;
    private String tel;
    private int age;
    private String gender;
}
