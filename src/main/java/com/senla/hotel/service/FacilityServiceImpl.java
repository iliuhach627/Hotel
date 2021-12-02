package com.senla.hotel.service;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.api.service.FacilityService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.mapper.FacilityMapper;
import com.senla.hotel.model.Facility;
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


    @Override
    public Collection<FacilityDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ УСЛУГИ!!!");
        return facilityDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FacilityDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        return mapper.toDto(facilityDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ВСЕГО В СЕРВИСЕ УСЛУГИ!!!");
        facilityDao.delete(id);
    }

    @Transactional
    @Override
    public void update(FacilityDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ УСЛУГИ!!!");
        Facility entity = mapper.toEntity(dto);
        facilityDao.update(entity);
    }

    @Override
    public Collection<FacilityDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ УСЛУГИ!!!");
        switch (key) {
            case TITLE:
                return facilityDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Facility::getTitle))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case PRICE:
                return facilityDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Facility::getPrice))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }
}
