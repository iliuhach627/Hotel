package com.senla.hotel.controller;

import com.senla.hotel.api.service.FacilityService;
import com.senla.hotel.dto.FacilityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.senla.hotel.model.enums.SortedKey;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @PostMapping
    public ResponseEntity<FacilityDto> create(@RequestBody FacilityDto facilityDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        return ResponseEntity.ok(facilityService.create(facilityDto));
    }

    @GetMapping
    public ResponseEntity<Collection<FacilityDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        return ResponseEntity.ok(facilityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        return ResponseEntity.ok(facilityService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        facilityService.delete(id);
    }

    @PatchMapping
    public void update(@RequestBody FacilityDto facilityDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        facilityService.update(facilityDto);
    }

    @GetMapping("/sort/{key}")
    public ResponseEntity<Collection<FacilityDto>> getSortedByKey(@PathVariable SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В КОНТРОЛЛЕРЕ УСЛУГИ!!!");
        return ResponseEntity.ok(facilityService.sortedByKey(key));
    }
}
