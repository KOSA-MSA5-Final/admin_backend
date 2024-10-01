package com.example.demo.domains.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String email;
    private String password;
    private String name;
    private String username;
    private String telNum;
}
