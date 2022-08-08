package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.controller.dto.UserLoginDto;
import com.yogesh.studentsystem.controller.dto.UserRegistrationDto;
import com.yogesh.studentsystem.model.User;
import com.yogesh.studentsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    private UserService userService;

    public UserLoginController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public String userLogin(@RequestBody UserLoginDto userLoginDto ){
        return this.userService.userLogin(userLoginDto);
    }

}
