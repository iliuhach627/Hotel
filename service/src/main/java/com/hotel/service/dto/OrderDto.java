package com.hotel.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    @Pattern(regexp = "202[0-5]-0[1-9]|1[0-2]-0[1-9]|[12][0-9]|3[01]")
    private LocalDate dateSettlement;
    @Pattern(regexp = "202[0-5]-0[1-9]|1[0-2]-0[1-9]|[12][0-9]|3[01]")
    private LocalDate dateFree;
    @NotNull
    private GuestDto guest;
    @NotNull
    private RoomDto room;
    @NotNull
    private List<FacilityDto> facilities;
}
