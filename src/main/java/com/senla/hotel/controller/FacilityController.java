package com.senla.hotel.controller;

import com.senla.hotel.api.service.FacilityService;
import com.senla.hotel.dto.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @PostMapping
    public ResponseEntity<FacilityDto> create(@RequestBody FacilityDto facilityDto)
    {
        return ResponseEntity.ok(facilityService.create(facilityDto));
    }

    @GetMapping
    public ResponseEntity<Collection<FacilityDto>> findAll()
    {
        return ResponseEntity.ok(facilityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityDto> findById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(facilityService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id)
    {
        facilityService.delete(id);
    }

    @PatchMapping
    public ResponseEntity<FacilityDto> update(@RequestBody FacilityDto facilityDto)
    {
        return ResponseEntity.ok(facilityService.update(facilityDto));
    }
}
