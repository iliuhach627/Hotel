package com.senla.hotel.api.service;

import com.senla.hotel.dto.FacilityDto;

import java.util.Collection;
import java.util.UUID;

public interface FacilityService {
    FacilityDto create(FacilityDto entity);
    Collection<FacilityDto> findAll();
    FacilityDto findById(UUID id);
    void delete(UUID id);
    FacilityDto update(FacilityDto entity);
}
