package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.model.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestDaoImpl extends AbstractDao<Guest> implements GuestDao {

    public GuestDaoImpl() {
        super(Guest.class);
    }
}