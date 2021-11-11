package com.senla.hotel.controller;

import com.senla.hotel.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;

    @GetMapping("/message")
    public String getMessage() {
        return testService.getMessage();
    }
}
