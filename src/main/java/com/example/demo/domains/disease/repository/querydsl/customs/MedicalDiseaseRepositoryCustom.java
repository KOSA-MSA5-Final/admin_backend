package com.example.demo.domains.disease.repository.querydsl.customs;

import com.example.demo.domains.disease.entity.MedicalDisease;

import java.util.List;

public interface MedicalDiseaseRepositoryCustom {

    // 커스텀 쿼리 메서드: 특정 조건으로 MedicalDisease 조회
    List<MedicalDisease> findCustomMedicalDiseases(String diseaseName, String progressStatus);
}
