package com.senla.hotel.controller;

import com.senla.hotel.api.service.RoomService;
import com.senla.hotel.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    private ResponseEntity<RoomDto> create(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.create(roomDto));
    }

    @GetMapping
    private ResponseEntity<Collection<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<RoomDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable UUID id) {
        roomService.delete(id);
    }

    @PatchMapping
    private ResponseEntity<RoomDto> update(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok(roomService.update(roomDto));
    }

    @PatchMapping("/{id}")
    private void changeStatus(@PathVariable UUID id) {
        roomService.changeStatus(id);
    }
}
