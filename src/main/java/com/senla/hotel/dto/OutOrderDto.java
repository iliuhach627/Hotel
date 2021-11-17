package com.senla.hotel.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OutOrderDto {
    private UUID id;
    private LocalDate dateSettlement;
    private LocalDate dateFree;
    private String guestName;
    private String guestSurName;
    private int roomNumber;
    private String facilityTitle;
}
