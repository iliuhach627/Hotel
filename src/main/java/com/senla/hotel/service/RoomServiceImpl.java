package com.senla.hotel.service;

import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.RoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final ModelMapper modelMapper;
    private final RoomDao roomDao;

    @Transactional
    @Override
    public RoomDto create(RoomDto dto) {
        Room entity = modelMapper.map(dto, Room.class);
        return modelMapper.map(roomDao.save(entity), RoomDto.class);
    }

    @Override
    public Collection<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto findById(UUID id) {
        return modelMapper.map(roomDao.findById(id),RoomDto.class);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        roomDao.delete(id);
    }

    @Transactional
    @Override
    public RoomDto update(RoomDto dto) {
        Room entity = modelMapper.map(dto, Room.class);
        return modelMapper.map(roomDao.save(entity), RoomDto.class);
    }

    @Transactional
    @Override
    public void changeStatus(UUID id) {
        Room entity = modelMapper.map(roomDao.findById(id), Room.class);
        modelMapper.map(roomDao.changeStatus(entity), RoomDto.class);
    }
}
