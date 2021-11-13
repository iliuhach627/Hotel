package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Facility extends BaseEntity {
    private String title;
    private int price;


}
