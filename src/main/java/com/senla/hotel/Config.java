package com.senla.hotel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.senla.hotel.service",
                "com.senla.hotel.repository",
                "com.senla.hotel.controller"})
public class Config {
}
