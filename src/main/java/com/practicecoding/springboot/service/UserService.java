package com.practicecoding.springboot.service;

import com.practicecoding.springboot.dto.UserDto;
import com.practicecoding.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto user);

    void deleteUser (Long id);
}
