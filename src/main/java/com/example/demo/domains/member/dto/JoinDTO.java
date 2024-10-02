package com.example.demo.domains.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {
    private String email;
    private String name;
    private String username;
    private String password;
    private String telNumber;
}

