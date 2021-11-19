package com.senla.hotel.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@Data
public class Order extends BaseEntity{
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private Guest guest;
    private Room room;
    private Facility facility;
}
