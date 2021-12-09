package com.hotel.service.impl;

import com.hotel.dao.api.FacilityDao;
import com.hotel.dao.model.Facility;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.api.mapper.FacilityMapper;
import com.hotel.service.api.service.FacilityService;
import com.hotel.service.dto.FacilityDto;
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
public class FacilityServiceImpl implements FacilityService {

    private final FacilityDao facilityDao;
    private final FacilityMapper mapper;

    @Transactional
    @Override
    public FacilityDto create(FacilityDto dto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ УСЛУГИ!!!");
        Facility entity = mapper.toEntity(dto);
        return mapper.toDto(facilityDao.save(entity));
    }

    @Transactional
    @Override
    public Collection<FacilityDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public FacilityDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityDao.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Falitity", "ID", id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        facilityDao.delete(id);
    }

    @Transactional
    @Override
    public void update(FacilityDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        Facility entity = mapper.toEntity(dto);
        facilityDao.update(entity);
    }

    @Transactional
    @Override
    public Collection<FacilityDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityDao.findAll()
                .stream()
                .sorted(getComparator(key))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Comparator<Facility> getComparator(SortedKey key) {
        Comparator<Facility> comparator = null;
        switch (key) {
            case TITLE:
                comparator = Comparator.comparing(Facility::getTitle);
                break;
            case PRICE:
                comparator = Comparator.comparing(Facility::getPrice);
                break;
        }
        return comparator;
    }
}
