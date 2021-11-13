package com.senla.hotel.api.service;

import com.senla.hotel.dto.GuestDto;
import java.util.Collection;
import java.util.UUID;

public interface GuestService {
    GuestDto create(GuestDto entity);
    Collection<GuestDto> findAll();
    GuestDto findById(UUID id);
    void delete(UUID id);
    GuestDto update(GuestDto entity);
}
