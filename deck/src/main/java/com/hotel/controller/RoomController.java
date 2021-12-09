package com.hotel.controller;

import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.api.service.RoomService;
import com.hotel.service.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> create(@Valid
                                          @RequestBody RoomDto roomDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        return ResponseEntity.ok(roomService.create(roomDto));
    }

    @GetMapping
    public ResponseEntity<Collection<RoomDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        return ResponseEntity.ok(roomService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        roomService.delete(id);
    }

    @PatchMapping
    public void update(@RequestBody RoomDto roomDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        roomService.update(roomDto);
    }

    @PatchMapping("/{id}")
    public void changeStatus(@PathVariable UUID id) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ СТАТУСА ОДНОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        roomService.changeStatus(id);
    }

    @GetMapping("/sort/{key}")
    public ResponseEntity<Collection<RoomDto>> getSortedByKey(@PathVariable SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В КОНТРОЛЛЕРЕ КОМНАТЫ!!!");
        return ResponseEntity.ok(roomService.sortedByKey(key));
    }
}
