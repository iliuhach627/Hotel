package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "guest")
@Data
public class Guest extends BaseEntity{
    @Column(value = "name")
    private String name;
    @Column(value = "surname")
    private String surName;
    @Column(value = "tel")
    private String tel;
    @Column(value = "age")
    private int age;
    @Column(value = "gender")
    private String gender;




}
