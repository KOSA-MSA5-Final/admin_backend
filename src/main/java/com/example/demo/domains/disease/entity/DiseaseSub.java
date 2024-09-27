package com.example.demo.domains.disease.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 소분류 엔티티
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */
@Entity
@Getter
@Setter
public class DiseaseSub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_disease_id")
    private Long id;

    @Column(name = "sub_disease_name")
    private String name;

    // 소분류는 대분류와 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_name_id")
    private DiseaseNames diseaseNames;
}

