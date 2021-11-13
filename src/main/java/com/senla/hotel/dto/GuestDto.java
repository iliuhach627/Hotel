package com.senla.hotel.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GuestDto {
    private UUID id;
    private String name;
    private String surName;
    private String tel;
    private int age;
    private String gender;
}
