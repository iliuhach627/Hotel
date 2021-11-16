package com.senla.hotel.model;

import lombok.Data;

@Data
public class Facility extends BaseEntity {
    private String title;
    private int price;
}
