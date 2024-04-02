package com.practicecoding.springboot.service.impl;

import com.practicecoding.springboot.dto.UserDto;
import com.practicecoding.springboot.entity.User;
import com.practicecoding.springboot.exception.EmailAlreadyExistException;
import com.practicecoding.springboot.exception.ResourceNotFoundException;
import com.practicecoding.springboot.mapper.AutoUserMapper;
import com.practicecoding.springboot.mapper.UserMapper;
import com.practicecoding.springboot.repository.UserRepository;
import com.practicecoding.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email already exists for a User");
        }
//        User user = UserMapper.mapToEntity(userDto);
        User user = modelMapper.map(userDto, User.class);
//        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
//        return UserMapper.mapToDto(userRepository.save(user));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser,UserDto.class);
//        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",id)
        );
//        return UserMapper.mapToDto(optionalUser.orElse(null));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
//                .map(user->UserMapper.mapToDto(user))
                .map(user->modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        User currentUser = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",id)
        );
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
//        return UserMapper.mapToDto(userRepository.save(currentUser));
        User savedUser = userRepository.save(currentUser);
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",id)
        );
        userRepository.deleteById(id);
    }


}
