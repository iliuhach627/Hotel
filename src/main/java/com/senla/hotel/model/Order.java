package com.senla.hotel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Data
public class Order extends BaseEntity{
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private Room room;
    private Collection<Guest> guestList;
    private Collection<Facility> facilityList;
}
