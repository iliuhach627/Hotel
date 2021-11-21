package com.senla.hotel.service;

import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.api.service.GuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.Guest;
import com.senla.hotel.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestDao guestDao;
    private final GuestMapper mapper;

    @Override
    public GuestDto create(GuestDto dto) {
        Guest entity = mapper.toEntity(dto);
        return mapper.toDto(guestDao.save(entity));
    }

    @Override
    public Collection<GuestDto> findAll() {
        return guestDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GuestDto findById(UUID id) {
        return mapper.toDto(guestDao.findById(id));
    }

    @Override
    public void delete(UUID id) {
        guestDao.delete(id);
    }

    @Override
    public GuestDto update(GuestDto dto) {
        Guest entity = mapper.toEntity(dto);
        return mapper.toDto(guestDao.save(entity));
    }
}
