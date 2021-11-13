package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "room")
@Data
public class Room extends BaseEntity{
    @Column(value = "number")
    private String number;
    @Column(value = "capacity")
    private int capacity;
    @Column(value = "status")
    private Status status;
    @Column(value = "price")
    private int price;

}
