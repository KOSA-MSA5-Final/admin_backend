package com.example.demo.domains.profile_medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 병원 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Entity
@Getter
@Setter
public class Hospital {
    @Id @Column(unique = true, nullable = false, name = "business_registration_number")
    Long id;

    @Column(name = "hospital_name")
    String name;

    @Column(name = "hospital_address")
    String address;

    @Column(name = "doctor_name")
    String doctor;

    @Column(name = "is_ours")
    String is_ours;

    @Column(name = "phone_number")
    String phone_number;
}
