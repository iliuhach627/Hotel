package com.senla.hotel.service;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.api.service.FacilityService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.mapper.FacilityMapper;
import com.senla.hotel.model.Facility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityDao facilityDao;
    private final FacilityMapper mapper;

    @Transactional
    @Override
    public FacilityDto create(FacilityDto dto) {
        Facility entity = mapper.toEntity(dto);
        return mapper.toDto(facilityDao.save(entity));
    }

    @Override
    public Collection<FacilityDto> findAll() {
        return facilityDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FacilityDto findById(UUID id) {
        return mapper.toDto(facilityDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        facilityDao.delete(id);
    }

    @Transactional
    @Override
    public FacilityDto update(FacilityDto dto) {
        Facility entity = mapper.toEntity(dto);
        return mapper.toDto(facilityDao.save(entity));
    }
}
