package com.senla.hotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {
    private String name;
    private String surName;
    private String tel;
    private int age;
    private String gender;

}
