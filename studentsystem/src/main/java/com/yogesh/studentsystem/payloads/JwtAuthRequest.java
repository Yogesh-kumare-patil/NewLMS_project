package com.yogesh.studentsystem.payloads;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class JwtAuthRequest {

    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 characters !!")
    private String username;

    @NotEmpty
    @Size(min = 3, max = 10, message = "password Must be Min of 3 chars and max of 10 chars !!")
    private String password;

}
