package com.example.demo.domains.disease.entity;

import com.example.demo.domains.profile_medical.entity.Medical;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : Medical, DiseaseNames 간의 관계 테이블로 사용되는 엔티티
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-25        김진석          최초 생성
 */
@Entity
@Getter
@Setter
public class MedicalDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_disease_id")
    private Long id;

    // 병명 대분류와 연관관계 (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "disease_name_id")
    private DiseaseNames diseaseNames;

    // 진료 기록과 연관관계 (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "medical_id")
    private Medical medical;

    // 질병 진행 상태 (T: 진행 중, F: 완료됨)
    @Column(name = "progress_status", nullable = false)
    private String progressStatus;

    // 진단 날짜
    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    // 엔티티가 persist되기 전에 호출되어 기본값을 설정
    @PrePersist
    public void prePersist() {
        if (this.progressStatus == null) {
            this.progressStatus = "T"; // 기본값을 "T"로 설정
        }
    }
}
