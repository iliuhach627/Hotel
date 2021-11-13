package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Data
public class Order extends BaseEntity{
    private String dateSettlement;
    private String dateFree;
    private Collection<Guest> guestList;
    private Collection<Room> roomList;

}
