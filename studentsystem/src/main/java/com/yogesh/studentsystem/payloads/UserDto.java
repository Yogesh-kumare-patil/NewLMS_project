package com.yogesh.studentsystem.payloads;

import com.yogesh.studentsystem.entities.Book;
import com.yogesh.studentsystem.entities.Cart;
import com.yogesh.studentsystem.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 characters !!")
    private String name;

    @Email(message = "Email Address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "password Must be Min of 3 chars and max of 10 chars !!")
    private String password;

    private Cart cart;

    private Set<RoleDto> roles = new HashSet<>();

}
