package com.yogesh.studentsystem.service.impl;



import com.yogesh.studentsystem.config.AppConstants;
import com.yogesh.studentsystem.entities.Cart;
import com.yogesh.studentsystem.entities.Role;
import com.yogesh.studentsystem.entities.User;
import com.yogesh.studentsystem.exceptions.ResourceNotFoundException;
import com.yogesh.studentsystem.payloads.UserDto;
import com.yogesh.studentsystem.repository.RoleRepo;
import com.yogesh.studentsystem.repository.UserRepo;
import com.yogesh.studentsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

        user.getRoles().add(role);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(user);
    }




    //Insted of this we are using Model Mapper to convert one class to Another
//    public User dtoToUser(UserDto userDto){
//        User user= new User();
//        user.setId(userDto.getId());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setName(userDto.getName());
//        return user;
//    }
//
//    public UserDto userToDto(User user){
//        UserDto userDto= new UserDto();
//        userDto.setId(user.getId());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setName(user.getName());
//        return userDto;
//    }


    public User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        // encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

        user.getRoles().add(role);

        User newUser = this.userRepo.save(user);

        return this.modelMapper.map(newUser, UserDto.class);
    }

}
