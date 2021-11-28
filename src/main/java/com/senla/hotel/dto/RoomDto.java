package com.senla.hotel.dto;

import com.senla.hotel.model.enums.RoomStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class RoomDto {
    @NotNull
    private UUID id;
    @Size(max = 4)
    @Pattern(regexp = "^[1-9][0-9]*")
    private String number;
    private RoomStatus status;
    @Size(max = 4)
    @Pattern(regexp = "^[1-9][0-9]*")
    private int price;
}
