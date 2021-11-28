package com.senla.hotel.controller;

import com.senla.hotel.api.service.GuestService;
import com.senla.hotel.dto.GuestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @PostMapping
    public ResponseEntity<GuestDto> create(@RequestBody GuestDto guestDto) {
        return ResponseEntity.ok(guestService.create(guestDto));
    }

    @GetMapping
    public ResponseEntity<Collection<GuestDto>> findAll() {
        return ResponseEntity.ok(guestService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(guestService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        guestService.delete(id);
    }

    @PatchMapping
    public ResponseEntity<GuestDto> update(@RequestBody GuestDto guestDto) {
        return ResponseEntity.ok(guestService.update(guestDto));
    }
}
