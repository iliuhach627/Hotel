package com.senla.hotel.service;

import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.RoomService;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.mapper.RoomMapper;
import com.senla.hotel.model.Facility;
import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.RoomStatus;
import com.senla.hotel.model.enums.SortedKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;
    private final RoomMapper mapper;

    @Transactional
    @Override
    public RoomDto create(RoomDto dto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ КОМНАТЫ!!!");
        Room entity = mapper.toEntity(dto);
        entity.setStatus(RoomStatus.FREE);
        return mapper.toDto(roomDao.save(entity));
    }

    @Override
    public Collection<RoomDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ КОМНАТЫ!!!");
        return roomDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        return mapper.toDto(roomDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        roomDao.delete(id);
    }

    @Transactional
    @Override
    public void update(RoomDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        Room entity = mapper.toEntity(dto);
        roomDao.save(entity);
    }

    @Transactional
    @Override
    public void changeStatus(UUID id) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ СТАТУСА ОДНОГО В СЕРВИСЕ КОМНАТЫ!!!");
        Room entity = roomDao.findById(id);
        roomDao.changeStatus(entity);
    }

    @Override
    public Collection<RoomDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ КОМНАТЫ!!!");
        switch (key) {
            case NUMBER:
                return roomDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Room::getNumber))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case STATUS:
                return roomDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Room::getStatus))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            case PRICE:
                return roomDao.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Room::getPrice))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }
}
