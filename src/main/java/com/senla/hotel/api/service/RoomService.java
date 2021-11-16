package com.senla.hotel.api.service;

import com.senla.hotel.dto.RoomDto;

import java.util.Collection;
import java.util.UUID;

public interface RoomService {
    RoomDto create(RoomDto entity);

    Collection<RoomDto> findAll();

    RoomDto findById(UUID id);

    void delete(UUID id);

    RoomDto update(RoomDto entity);

    void changeStatus(UUID id);
}
