package com.senla.hotel.repository;

import com.senla.hotel.api.repository.TestDao;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
