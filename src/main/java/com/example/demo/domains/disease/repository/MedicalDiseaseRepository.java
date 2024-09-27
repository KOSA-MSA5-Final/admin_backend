package com.example.demo.domains.disease.repository;

import com.example.demo.domains.disease.entity.MedicalDisease;
import com.example.demo.domains.disease.repository.querydsl.customs.MedicalDiseaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalDiseaseRepository extends JpaRepository<MedicalDisease, Long>, MedicalDiseaseRepositoryCustom {
    // 특정 병명으로 MedicalDisease 조회 (진행 중인 질병만 조회)
    List<MedicalDisease> findByDiseaseNames_NameAndProgressStatus(String diseaseName, String progressStatus);

    // 특정 진료 기록과 연관된 MedicalDisease 조회
    List<MedicalDisease> findByMedical_Id(Long medicalId);
}
