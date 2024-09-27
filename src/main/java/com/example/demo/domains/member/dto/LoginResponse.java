package com.example.demo.domains.member.dto;


import com.example.demo.domains.member.entity.RefreshToken;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private RefreshToken refreshToken;

    public LoginResponse(String accessToken, RefreshToken refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
