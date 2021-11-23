package com.senla.hotel.api.repository;

import com.senla.hotel.model.User;

public interface UserDao extends BaseDao<User>{
    User loadUserByUsername(String s);
}
