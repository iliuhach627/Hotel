package com.senla.hotel.service;

import com.senla.hotel.api.repository.UserDao;
import com.senla.hotel.api.service.UserService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.dto.UserDto;
import com.senla.hotel.mapper.UserMapper;
import com.senla.hotel.model.Facility;
import com.senla.hotel.model.User;
import com.senla.hotel.model.enums.SortedKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserDao userDao;

    @Transactional
    @Override
    public UserDto create(UserDto dto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ЮЗЕРА!!!");
        User entity = mapper.toEntity(dto);
        return mapper.toDto(userDao.save(entity));
    }

    @Override
    public Collection<UserDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ЮЗЕРА!!!");
        return userDao.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ЮЗЕРА!!!");
        return mapper.toDto(userDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ЮЗЕРА!!!");
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(UserDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИ ОДНОГО В СЕРВИСЕ ЮЗЕРА!!!");
        User entity = mapper.toEntity(dto);
        userDao.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("Я - МЕТОД АКТИВАЦИИ АДМИНА В СЕРВИСЕ ЮЗЕРА!!!");
        User user = userDao.loadUserByUsername(userName);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getStatus().getRole()))
        );
    }

    @Override
    public Collection<UserDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ ЮЗЕРА!!!");
        switch (key) {
            case USERNAME:
                return userDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(User::getUsername))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case STATUS:
                return userDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(User::getStatus))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case PASSWORD:
                return userDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(User::getPassword))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }
}
