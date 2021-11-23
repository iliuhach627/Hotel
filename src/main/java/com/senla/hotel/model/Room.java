package com.senla.hotel.model;

import com.senla.hotel.model.enums.RoomStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity{
    private String number;
    private RoomStatus roomStatus;
    private int price;
}
