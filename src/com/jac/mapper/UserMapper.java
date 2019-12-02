package com.jac.mapper;

import com.jac.model.User;
import com.jac.model.User_order;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);
    int deleteUser(int id);
    User findById(int id);
    User findByUserId(User_order user_order);
    List<User> findByName(User user);
    List<User> findByAny(User user);
}
