package com.senla.hotel.dto;

import com.senla.hotel.model.enums.UserStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String username;
    private UserStatus status;
    private String password;
}
