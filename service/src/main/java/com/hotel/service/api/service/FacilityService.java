package com.hotel.service.api.service;

import com.hotel.dao.model.Facility;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.dto.FacilityDto;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;

public interface FacilityService {
    FacilityDto create(FacilityDto entity);

    Collection<FacilityDto> findAll();

    FacilityDto findById(UUID id);

    void delete(UUID id);

    void update(FacilityDto entity);

    Collection<FacilityDto> sortedByKey(SortedKey key);

    Comparator<Facility> getComparator(SortedKey key);
}
