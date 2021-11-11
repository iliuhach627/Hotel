package com.senla.hotel;

import com.senla.hotel.api.repository.TestDao;
import com.senla.hotel.api.service.TestService;
import com.senla.hotel.controller.TestController;
import com.senla.hotel.repository.TestDaoImpl;
import com.senla.hotel.service.TestServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

@SpringBootApplication
public class Runner extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
//
//        TestDao testDao = new TestDaoImpl();
//        System.out.println(applicationContext.getBean(TestController.class).getMessage());

    }
}