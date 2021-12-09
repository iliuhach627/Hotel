package com.hotel.dao.api;

import com.hotel.dao.model.User;

public interface UserDao extends BaseDao<User> {
    User loadUserByUsername(String s);
}
