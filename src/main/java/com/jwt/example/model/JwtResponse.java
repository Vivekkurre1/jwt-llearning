package com.jwt.example.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse {
    private String jwtToken;
    private String userName;
}
