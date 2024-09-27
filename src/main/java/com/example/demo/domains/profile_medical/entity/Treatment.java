package com.example.demo.domains.profile_medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 목록 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Entity
@Getter
@Setter
public class Treatment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private long id;

    @Column(name = "treatment_name")
    private String name;

    @Column(name = "treatment_price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "medical_id")
    Medical medical;
}
