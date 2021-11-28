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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "guestid", referencedColumnName = "id")
    private Guest guest;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomid", referencedColumnName = "id")
    private Room room;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "orders_facilities",
            joinColumns = @JoinColumn(name = "ordersid"),
            inverseJoinColumns = @JoinColumn(name = "facilitiesid")
    )
    private List<Facility> facilities;
}
