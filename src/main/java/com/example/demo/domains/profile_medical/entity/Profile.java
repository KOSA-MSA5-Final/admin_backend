package com.example.demo.domains.profile_medical.entity;

import com.example.demo.domains.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 프로필 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @Column(name = "profile_name")
    private String name;

    @Column(name = "profile_age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "member_id") // 외래 키를 명시적으로 지정
    private Member member;

    @ManyToOne
    @JoinColumn(name = "animalDetail_id") // 외래 키를 명시적으로 지정
    private AnimalDetail animalDetail;

    @Column(name = "profile_picture_url")
    private String pictureUrl;
}
