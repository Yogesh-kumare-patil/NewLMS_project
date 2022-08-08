package com.yogesh.studentsystem.service;


import com.yogesh.studentsystem.controller.dto.UserLoginDto;
import com.yogesh.studentsystem.controller.dto.UserRegistrationDto;
import com.yogesh.studentsystem.model.User;
import com.yogesh.studentsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user= new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRoles(registrationDto.getRole());
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username){
        User user = userRepository.findByEmail(username);
        return user;
    }

    public String userLogin(UserLoginDto userLoginDto) {
//        if (userLoginDto.getEmail().length() != 0 && (userRepository.findByEmail(userLoginDto.getEmail())).getEmail().equals(userLoginDto.getEmail())) {

//        if (userLoginDto.getEmail()!= null) {
            if(ofNullable(ofNullable(userRepository.findByEmail(userLoginDto.getEmail())).orElse(new User()).getPassword()).orElse("").equals(userLoginDto.getPassword()))
                return "logged in successfully";
            else
                return "enter valid email or password";
        }
//        else {
//            return "Enter Valid Email";
//        }
//    }

}
