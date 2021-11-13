package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Room extends BaseEntity{
    private String number;
    private int capacity;
    private Status status;
    private int price;

}
