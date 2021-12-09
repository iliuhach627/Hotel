package com.hotel.service.api.service;

import com.hotel.dao.model.User;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto create(UserDto entity);

    Collection<UserDto> findAll();

    UserDto findById(UUID id);

    void delete(UUID id);

    void update(UserDto entity);

    Collection<UserDto> sortedByKey(SortedKey key);

    Comparator<User> getComparator(SortedKey key);
}
