package com.senla.hotel.controller;

import com.senla.hotel.api.service.RoomService;
import com.senla.hotel.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.create(roomDto));
    }

    @GetMapping
    public  ResponseEntity<Collection<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<RoomDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable UUID id) {
        roomService.delete(id);
    }

    @PatchMapping
    public  ResponseEntity<RoomDto> update(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.update(roomDto));
    }

    @PatchMapping("/{id}")
    public  void changeStatus(@PathVariable UUID id) {
        roomService.changeStatus(id);
    }
}
