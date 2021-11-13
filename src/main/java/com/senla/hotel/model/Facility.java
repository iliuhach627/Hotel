package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "facility")
@Data
public class Facility extends BaseEntity {
    @Column(value = "title")
    private String title;
    @Column(value = "price")
    private int price;


}
