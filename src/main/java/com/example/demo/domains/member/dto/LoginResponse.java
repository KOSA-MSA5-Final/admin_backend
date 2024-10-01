package com.example.demo.domains.member.dto;


import com.example.demo.domains.member.entity.RefreshToken;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
}
