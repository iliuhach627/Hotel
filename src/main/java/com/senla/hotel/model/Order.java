package com.senla.hotel.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class Order extends BaseEntity{
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private Room room;
    private Guest guest;
    private Collection<Facility> facilityList;
}
