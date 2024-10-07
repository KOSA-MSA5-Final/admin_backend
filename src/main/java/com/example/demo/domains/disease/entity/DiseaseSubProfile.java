package com.example.demo.domains.disease.entity;

import com.example.demo.domains.profile_medical.entity.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * author : 나선주
 * date : 2024-09-24
 * description : DiseaseSubProfile(join)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 * 2024-10-07       김진석          엔티티 수정
 */

@Entity
@Getter
@Setter
public class DiseaseSubProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="disease_sub_id")
    private DiseaseSub diseaseSub;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile profile;

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
        if (this.diagnosisDate == null) {
            this.diagnosisDate = new Date(); // 진단 날짜를 오늘 날짜로 설정
        }
    }
}
