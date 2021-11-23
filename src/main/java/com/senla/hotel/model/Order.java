package com.senla.hotel.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "dataset")
    private LocalDate dateSettlement;

    @Column(name = "datafree")
    private LocalDate dateFree;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_facilities",
            joinColumns = @JoinColumn(name = "orderid"),
            inverseJoinColumns = @JoinColumn(name = "facilityid")
    )
    private List<Facility> facilities;
}
