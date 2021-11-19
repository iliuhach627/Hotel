package com.senla.hotel.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private GuestDto guest;
    private RoomDto room;
    private FacilityDto facility;
}
