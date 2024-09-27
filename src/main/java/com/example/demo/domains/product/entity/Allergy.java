/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지 엔티티
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */
package com.example.demo.domains.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergy_id")
    private int id;

    @Column(name = "allergy_name")
    private String name;    // 알러지 이름

    @Column(name = "allergy_symptoms")
    private String symptoms;// 알러지 증상

//    @ManyToOne
//    @JoinColumn(name = "profile_id")  // Profile 외래 키
//    private Profile profile;  // Profile와의 다대일 관계
}

