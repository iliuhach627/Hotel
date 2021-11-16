package com.senla.hotel.model;

import lombok.Data;

@Data
public class Room extends BaseEntity{
    private String number;
    private Status status;
    private int price;
}
