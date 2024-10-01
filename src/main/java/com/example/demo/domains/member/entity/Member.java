package com.example.demo.domains.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : 회원
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long member_id;

    @Column(name="member_name")
    private String name;

    @Column(name="account_id")
    private String username;

    @Column(name="member_email")
    private String email;
    @Column( name="member_password")
    private String password;

    @Column(name="member_telNum")
    private String telNum;


    private String role;

}
