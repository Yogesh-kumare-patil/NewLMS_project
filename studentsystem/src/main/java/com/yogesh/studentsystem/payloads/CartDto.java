package com.yogesh.studentsystem.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

//    private Integer userId;

    private String userEmail;
    private String bookTitle;

    @Data
    public static class JwtAuthResponse {

        private String tocken;
    }
}
