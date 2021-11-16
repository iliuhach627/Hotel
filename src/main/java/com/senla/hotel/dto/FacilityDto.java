package com.senla.hotel.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class FacilityDto {
    private UUID id;
    private String title;
    private int price;

}
