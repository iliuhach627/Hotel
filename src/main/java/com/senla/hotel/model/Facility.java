package com.senla.hotel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "facilities")
public class Facility extends BaseEntity {
    private String title;
    private int price;

    @ManyToMany(mappedBy = "facilities")
    private List<Order> orders;
}
