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
public class Member  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long member_id;

    @Column(nullable = false, name="member_name")
    private String name;
    @Column(nullable = false, name="member_email")
    private String email;
    @Column(nullable = false, name="member_password")
    private String password;

    @Column(name="member_telNum")
    private String telNum;

    @Builder
    public Member(String email, String password, String telNum) {
        this.email = email;
        this.password = password;
    }

    //아래는 userDetails의 override method
    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //사용자가 가지고 있는 권한의 목록을 반환합니다.
        //현재는 사용자 이외의 권한이 없기 때문에 user권한만 담아 반환합니다.

        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    //계정만료여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //만료되었는지 확인하는 로직
        return true;//true -> 만료되지 않았음
    }

    //계정 잠금여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금되었는지 확인하는 로직
        return true; //true -> 잠금되지 않았음
    }

    //패스워드의 만료여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        //패스워드가 만료되었는지 확인하는 로직
        return true; //true -> 만료되지 않았음
    }

    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        //계정이 사용 가능한지 확인하는 로직
        return true;//true -> 사용가능
    }

}
