package com.senla.hotel.service;

import com.senla.hotel.api.repository.TestDao;
import com.senla.hotel.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestServiceImpl implements TestService {
    private final TestDao testDao;

    @Override
    public String getMessage() {
        return testDao.getMessage();
    }
}
