package com.senla.hotel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Facility extends BaseEntity {
    private String title;
    private int price;
    private Facility(String title,int price){
        this.title=title;
        this.price=price;
    }

    @Override
    public String toString() {
        return String.format("\nFacility:" +
                        "\r\n\ttitle: %s" +
                        "\r\n\tprice: %d",
                title,price);
    }

}
