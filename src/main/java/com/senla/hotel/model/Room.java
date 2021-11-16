package com.senla.hotel.model;

import com.senla.hotel.model.enums.Status;
import lombok.Data;

@Data
public class Room extends BaseEntity{
    private String number;
    private Status status;
    private int price;
}
