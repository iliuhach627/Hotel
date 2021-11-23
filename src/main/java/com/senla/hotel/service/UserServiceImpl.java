package com.senla.hotel.service;

import com.senla.hotel.api.repository.UserDao;
import com.senla.hotel.api.service.UserService;
import com.senla.hotel.dto.UserDto;
import com.senla.hotel.mapper.UserMapper;
import com.senla.hotel.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserDao userDao;

    @Transactional
    @Override
    public UserDto create(UserDto dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(userDao.save(entity));
    }

    @Override
    public Collection<UserDto> findAll() {
        return userDao.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(UUID id) {
        return mapper.toDto(userDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public UserDto update(UserDto dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(userDao.save(entity));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(userName);
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getUserStatus().stream()
                        .map(status -> new SimpleGrantedAuthority(status.getRole()))
                        .collect(Collectors.toList())
        );
    }
}
