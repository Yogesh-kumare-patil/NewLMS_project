package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.controller.dto.UserRegistrationDto;
import com.yogesh.studentsystem.model.User;
import com.yogesh.studentsystem.repository.UserRepository;
import com.yogesh.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/user")
    public User registrationUser(@RequestBody UserRegistrationDto userRegistrationDto ) {
        return userService.save(userRegistrationDto);
    }
    @GetMapping("/user/{username}")
    @ResponseBody
    public User userDetails(@PathVariable("username") String userName){
        return userService.loadUserByUsername(userName);
    }

}
