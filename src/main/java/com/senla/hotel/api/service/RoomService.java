package com.senla.hotel.api.service;

import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.model.enums.SortedKey;

import java.util.Collection;
import java.util.UUID;

public interface RoomService {
    RoomDto create(RoomDto entity);

    Collection<RoomDto> findAll();

    RoomDto findById(UUID id);

    void delete(UUID id);

    void update(RoomDto entity);

    void changeStatus(UUID id);

    Collection<RoomDto> sortedByKey(SortedKey key);
}
