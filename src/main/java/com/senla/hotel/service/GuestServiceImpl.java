package com.senla.hotel.service;

import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.api.service.GuestService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.Guest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final ModelMapper modelMapper;
    private final GuestDao guestDao;

    @Transactional
    @Override
    public GuestDto create(GuestDto dto) {
        Guest entity = modelMapper.map(dto, Guest.class);
        return modelMapper.map(guestDao.save(entity), GuestDto.class);
    }

    @Override
    public Collection<GuestDto> findAll() {
        return guestDao.findAll().stream()
                .map(guest -> modelMapper.map(guest, GuestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GuestDto findById(UUID id) {
        return modelMapper.map(guestDao.findById(id), GuestDto.class);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        guestDao.delete(id);
    }

    @Transactional
    @Override
    public GuestDto update(GuestDto dto) {
        Guest entity = modelMapper.map(dto, Guest.class);
        return modelMapper.map(guestDao.save(entity), GuestDto.class);
    }
}
