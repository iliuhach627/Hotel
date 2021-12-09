package com.hotel.service.dto;

import com.hotel.dao.model.enums.UserStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    @NotNull
    @Size(max = 20)
    private String username;
    @NotNull
    private UserStatus status;
    @NotNull
    private String password;
}
