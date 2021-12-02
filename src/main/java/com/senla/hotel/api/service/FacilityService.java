package com.senla.hotel.api.service;

import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.model.enums.SortedKey;

import java.util.Collection;
import java.util.UUID;

public interface FacilityService {
    FacilityDto create(FacilityDto entity);

    Collection<FacilityDto> findAll();

    FacilityDto findById(UUID id);

    void delete(UUID id);

    void update(FacilityDto entity);

    Collection<FacilityDto> sortedByKey(SortedKey key);
}
