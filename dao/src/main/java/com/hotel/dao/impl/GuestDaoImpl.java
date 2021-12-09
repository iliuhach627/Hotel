package com.hotel.dao.impl;

import com.hotel.dao.api.GuestDao;
import com.hotel.dao.model.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestDaoImpl extends AbstractDao<Guest> implements GuestDao {

    public GuestDaoImpl() {
        super(Guest.class);
    }
}