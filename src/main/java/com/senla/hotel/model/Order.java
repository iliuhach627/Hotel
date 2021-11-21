package com.senla.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Order extends BaseEntity{
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private Guest guest;
    private Room room;
    private Facility facility;
}
