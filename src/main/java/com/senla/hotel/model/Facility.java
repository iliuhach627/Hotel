package com.senla.hotel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Facility extends BaseEntity{
    private String title;
    private int price;
    private Facility(String title,int price){
        this.title=title;
        this.price=price;
    }
}
