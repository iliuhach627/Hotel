package com.hotel.service.api.mapper;

import com.hotel.dao.model.User;
import com.hotel.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseMapper<UserDto, User> {

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @Override
    @Mapping(target = "password", qualifiedByName = "encode")
    public abstract User toEntity(UserDto userDto);

    @Named("encode")
    public String encode(String password) {
        return encoder.encode(password);
    }
}
