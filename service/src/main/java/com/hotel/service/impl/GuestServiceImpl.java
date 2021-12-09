package com.hotel.service.impl;

import com.hotel.dao.api.GuestDao;
import com.hotel.dao.model.Guest;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.api.mapper.GuestMapper;
import com.hotel.service.api.service.GuestService;
import com.hotel.service.dto.GuestDto;
import com.hotel.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestDao guestDao;
    private final GuestMapper mapper;

    @Transactional
    @Override
    public GuestDto create(GuestDto dto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ГОСТЯ!!!");
        Guest entity = mapper.toEntity(dto);
        return mapper.toDto(guestDao.save(entity));
    }

    @Transactional
    @Override
    public Collection<GuestDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public GuestDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestDao.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Guest", "ID", id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        guestDao.delete(id);
    }

    @Transactional
    @Override
    public void update(GuestDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        Guest entity = mapper.toEntity(dto);
        guestDao.update(entity);
    }

    @Override
    public Collection<GuestDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestDao.findAll()
                .stream()
                .sorted(getComparator(key))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Comparator<Guest> getComparator(SortedKey key) {
        Comparator<Guest> comparator = null;
        switch (key) {
            case NAME:
                comparator = Comparator.comparing(Guest::getName);
                break;
            case SURNAME:
                comparator = Comparator.comparing(Guest::getSurname);
                break;
            case TEL:
                comparator = Comparator.comparing(Guest::getTel);
                break;
            case AGE:
                comparator = Comparator.comparing(Guest::getAge);
                break;
            case GENDER:
                comparator = Comparator.comparing(Guest::getGender);
                break;
        }
        return comparator;
    }
}
