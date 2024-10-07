package com.example.demo.domains.profile_medical.entity;

import com.example.demo.domains.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

// import org.checkerframework.checker.units.qual.C;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 프로필 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 * 2024-10-04         나선주           column추가(gender, birthday, isneutered, willneutered)
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

    @Column(name="profile_gender")
    private String gender;

    @Column(name = "profile_age")
    private Integer age;

    @Column(name="profile_birthday")
    private Date birthday;

    @Column(name="profile_isneutered")
    private String isneutered;

    @Column(name="profile_willneutered")
    private String willneutered;

    @ManyToOne
    @JoinColumn(name = "member_id") // 외래 키를 명시적으로 지정
    private Member member;

    @ManyToOne
    @JoinColumn(name = "animalDetail_id") // 외래 키를 명시적으로 지정
    private AnimalDetail animalDetail;

    @Column(name = "profile_picture_url")
    private String pictureUrl;

    @Column(name="is_current")
    private String isCurrent; //T: true, F: false로 구분
}
