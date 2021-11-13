package com.senla.hotel.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
