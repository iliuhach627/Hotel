package com.senla.hotel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends BaseEntity{
    private String dateSettlement;
    private String dateFree;
    private List<Guest> guestList;
    private List<Room> roomList;
    private Order(String dateSettlement,String dateFree,List<Guest> guestList,List<Room> roomList){
        this.dateSettlement=dateSettlement;
        this.dateFree=dateFree;
        this.guestList=guestList;
        this.roomList=roomList;
    }
}
