package com.jwt.example.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtRequest {
    private String email;
    private String password;
}
