package com.example.demo.dtos;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserAllInfoDTO {
    public Member member;
    public List<SimpleProfileDTO> profiles;

    public UserAllInfoDTO(Member member, List<Profile> profiles) {
        this.member = member;
        this.profiles = new ArrayList<>();
        if(profiles.size() > 0) {
            for (Profile p : profiles) {
                this.profiles.add(new SimpleProfileDTO(p));
            }
        }

    }
}
