package com.senla.hotel.api.service;

import com.senla.hotel.dto.UserDto;
import com.senla.hotel.model.enums.SortedKey;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto create(UserDto entity);

    Collection<UserDto> findAll();

    UserDto findById(UUID id);

    void delete(UUID id);

    void update(UserDto entity);

    Collection<UserDto> sortedByKey(SortedKey key);
}
