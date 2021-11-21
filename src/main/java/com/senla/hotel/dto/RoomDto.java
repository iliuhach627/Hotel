package com.senla.hotel.dto;

import com.senla.hotel.model.enums.RoomStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class RoomDto {
    private UUID id;
    private String number;
    private RoomStatus roomStatus;
    private int price;
}
