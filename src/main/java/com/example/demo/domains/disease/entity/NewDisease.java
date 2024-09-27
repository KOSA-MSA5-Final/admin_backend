package com.example.demo.domains.disease.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새로운 병명 엔티티
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */
@Entity
@Getter
@Setter
public class NewDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "new_disease_id")
    private Long id;

    @Column(name = "new_disease_name")
    private String name;

    // 새로운 병명은 대분류와 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_name_id")
    private DiseaseNames diseaseNames;
}
