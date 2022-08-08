package com.yogesh.studentsystem.service;


import com.yogesh.studentsystem.controller.dto.UserLoginDto;
import com.yogesh.studentsystem.controller.dto.UserRegistrationDto;
import com.yogesh.studentsystem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   User save(UserRegistrationDto userRegistrationDto);
   User loadUserByUsername(String username);
   String userLogin(UserLoginDto userLoginDto);
}

