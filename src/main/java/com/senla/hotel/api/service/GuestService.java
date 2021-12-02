package com.senla.hotel.api.service;

import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.enums.SortedKey;

import java.util.Collection;
import java.util.UUID;

public interface GuestService {
    GuestDto create(GuestDto entity);

    Collection<GuestDto> findAll();

    GuestDto findById(UUID id);

    void delete(UUID id);

    void update(GuestDto entity);

    Collection<GuestDto> sortedByKey(SortedKey key);
}
