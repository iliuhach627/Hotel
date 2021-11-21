package com.senla.hotel.dto;

import com.senla.hotel.model.enums.UserStatus;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private Collection<UserStatus> userStatus;
    private String password;
}
