package com.myProject.mapper;

import com.myProject.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> findAll();

     int insertOne(User user);
}
