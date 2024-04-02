package com.practicecoding.springboot.mapper;

import com.practicecoding.springboot.dto.UserDto;
import com.practicecoding.springboot.entity.User;

public class UserMapper {

    public static User mapToEntity(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

    public static UserDto mapToDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
