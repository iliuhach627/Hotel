package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class Room extends BaseEntity{
    private String number;
    private Status status;
    private int price;

}
