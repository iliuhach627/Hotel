package com.senla.hotel.model;

import com.senla.hotel.model.enums.RoomStatus;
import lombok.Data;

@Data
public class Room extends BaseEntity{
    private String number;
    private RoomStatus roomStatus;
    private int price;
}
