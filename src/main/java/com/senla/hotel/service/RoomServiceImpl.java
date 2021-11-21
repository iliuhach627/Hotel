package com.senla.hotel.service;

import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.RoomService;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.mapper.RoomMapper;
import com.senla.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;
    private final RoomMapper mapper;

    @Override
    public RoomDto create(RoomDto dto) {
        Room entity = mapper.toEntity(dto);
        return mapper.toDto(roomDao.save(entity));
    }

    @Override
    public Collection<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto findById(UUID id) {
        return mapper.toDto(roomDao.findById(id));
    }

    @Override
    public void delete(UUID id) {
        roomDao.delete(id);
    }

    @Override
    public RoomDto update(RoomDto dto) {
        Room entity = mapper.toEntity(dto);
        return mapper.toDto(roomDao.save(entity));
    }

    @Override
    public void changeStatus(UUID id) {
        Room entity = roomDao.findById(id);
        roomDao.changeStatus(entity);
    }
}
