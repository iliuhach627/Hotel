package com.hotel.service.api.service;

import com.hotel.dao.model.Guest;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.dto.GuestDto;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;

public interface GuestService {
    GuestDto create(GuestDto entity);

    Collection<GuestDto> findAll();

    GuestDto findById(UUID id);

    void delete(UUID id);

    void update(GuestDto entity);

    Collection<GuestDto> sortedByKey(SortedKey key);

    Comparator<Guest> getComparator(SortedKey key);
}
