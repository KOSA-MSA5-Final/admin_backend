package com.example.demo.domains.profile_medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 기록 - 병원 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Entity
@Getter
@Setter
public class MedicalHospital {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="business_registration_number")
    Hospital hospital;

    @ManyToOne
    @JoinColumn(name="medical_id")
    Medical medical;
}
