package com.senla.hotel.service;

import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.api.service.GuestService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.Facility;
import com.senla.hotel.model.Guest;
import com.senla.hotel.mapper.GuestMapper;
import com.senla.hotel.model.enums.SortedKey;
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

    @Override
    public Collection<GuestDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ГОСТЯ!!!");
        return guestDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GuestDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return mapper.toDto(guestDao.findById(id));
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
        switch (key) {
            case NAME:
                return guestDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Guest::getName))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case SURNAME:
                return guestDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Guest::getSurname))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case TEL:
                return guestDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Guest::getTel))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case AGE:
                return guestDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Guest::getAge))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case GENDER:
                return guestDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Guest::getGender))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }
}
