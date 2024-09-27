package com.example.demo.domains.disease.service.interfaces;

import com.example.demo.domains.disease.entity.MedicalDisease;

import java.util.List;

public interface MedicalDiseaseService {

    // 새로운 MedicalDisease 생성
    MedicalDisease createMedicalDisease(MedicalDisease medicalDisease);

    // 특정 병명과 진행 상태로 MedicalDisease 조회
    List<MedicalDisease> findByDiseaseNameAndProgressStatus(String diseaseName, String progressStatus);

    // 특정 진료 기록에 연관된 MedicalDisease 조회
    List<MedicalDisease> findByMedicalId(Long medicalId);

    // ID로 MedicalDisease 기록을 삭제하는 메서드
    Boolean deleteMedicalDiseaseById(Long id);
}