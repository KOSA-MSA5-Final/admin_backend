package com.example.demo.domains.disease.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 엔티티
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */
@Entity
@Getter
@Setter
public class DiseaseNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_name_id")
    private Long id;

    @Column(name = "disease_name")
    private String name;

    // 대분류와 소분류는 1대다 관계
    @OneToMany(mappedBy = "diseaseNames", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiseaseSub> diseaseSubs;

    // 대분류와 새로운 병명은 1대다 관계
    @OneToMany(mappedBy = "diseaseNames", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NewDisease> newDiseases;

}
