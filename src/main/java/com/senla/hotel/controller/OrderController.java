package com.senla.hotel.controller;

import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    private ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.create(orderDto));
    }

    @GetMapping
    private ResponseEntity<Collection<OrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<OrderDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable UUID id) {
        orderService.delete(id);
    }

    @PatchMapping
    private void update(@RequestBody OrderDto orderDto) {
        orderService.update(orderDto);
    }
}
