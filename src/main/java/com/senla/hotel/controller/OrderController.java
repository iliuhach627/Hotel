package com.senla.hotel.controller;

import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.enums.SortedKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        return ResponseEntity.ok(orderService.create(orderDto));
    }

    @GetMapping
    public ResponseEntity<Collection<OrderDto>> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        orderService.delete(id);
    }

    @PatchMapping
    public void update(@RequestBody OrderDto orderDto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        orderService.update(orderDto);
    }

    @GetMapping("/sort/{key}")
    public ResponseEntity<Collection<OrderDto>> getSortedByKey(@PathVariable SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        return ResponseEntity.ok(orderService.sortedByKey(key));
    }

    @GetMapping("/guests")
    public ResponseEntity<Collection<GuestDto>> findAllGuestsByRoomAndDate(@RequestParam String number,
                                                                           @RequestParam
                                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                   LocalDate date) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕХ ГОСТЕЙ ИЗ КОМНАТЫ ПО ДАТЕ В КОНТРОЛЛЕРЕ ЗАКАЗА!!!");
        return ResponseEntity.ok(orderService.findAllGuestsByRoomAndDate(number, date));
    }
}
