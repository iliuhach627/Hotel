package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;
import java.util.Date;

@Table(value = "order")
@Data
public class Order extends BaseEntity{
    @Column(value = "dateset")
    private Date dateSettlement;
    @Column(value = "datefree")
    private Date dateFree;
    @Column(value = "room")
    private Room room;
    @Column(value = "guestlist")
    private Collection<Guest> guestList;
    @Column(value = "facilitylist")
    private Collection<Facility> facilityList;

}
