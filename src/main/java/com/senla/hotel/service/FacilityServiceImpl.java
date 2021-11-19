package com.senla.hotel.service;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.api.service.FacilityService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.model.Facility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final ModelMapper modelMapper;
    private final FacilityDao facilityDao;

    @Transactional
    @Override
    public FacilityDto create(FacilityDto dto) {
        Facility entity = modelMapper.map(dto, Facility.class);
        return modelMapper.map(facilityDao.save(entity), FacilityDto.class);
    }

    @Override
    public Collection<FacilityDto> findAll() {
        return facilityDao.findAll().stream()
                .map(facility -> modelMapper.map(facility, FacilityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FacilityDto findById(UUID id) {
        return modelMapper.map(facilityDao.findById(id), FacilityDto.class);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        facilityDao.delete(id);
    }

    @Transactional
    @Override
    public FacilityDto update(FacilityDto dto) {
        Facility entity = modelMapper.map(dto, Facility.class);
        return modelMapper.map(facilityDao.save(entity), FacilityDto.class);
    }
}
