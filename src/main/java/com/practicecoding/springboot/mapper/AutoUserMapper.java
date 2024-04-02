package com.practicecoding.springboot.mapper;

import com.practicecoding.springboot.dto.UserDto;
import com.practicecoding.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    // In order to map one object to another object both object
    // should have same field name.
    // If the field names are different we have to map fields using the
    // following annotations.

//    @Mapping(source = "email", target = "emailAddress")
//    UserDto mapToUserDto(User user);

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
