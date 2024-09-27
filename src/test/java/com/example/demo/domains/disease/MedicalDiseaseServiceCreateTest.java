package com.example.demo.domains.disease;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.MedicalDisease;
import com.example.demo.domains.disease.service.interfaces.MedicalDiseaseService;
import com.example.demo.domains.profile_medical.entity.Medical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class MedicalDiseaseServiceCreateTest {

    @Autowired
    private MedicalDiseaseService medicalDiseaseService;

    private MedicalDisease medicalDisease;

    @BeforeEach
    public void setUp() {
        // 병명 대분류
        DiseaseNames diseaseNames = new DiseaseNames();
        diseaseNames.setName("순환계통(심장)");

        // 진료 기록
        Medical medical = new Medical();
        medical.setVisitDate(new Date());

        // MedicalDisease 생성
        medicalDisease = new MedicalDisease();
        medicalDisease.setDiseaseNames(diseaseNames);
        medicalDisease.setMedical(medical);
        medicalDisease.setProgressStatus("T");
        medicalDisease.setDiagnosisDate(new Date());
    }

    @Test
    @Transactional
    public void testCreateMedicalDisease() {
        // MedicalDisease 저장
        MedicalDisease savedMedicalDisease = medicalDiseaseService.createMedicalDisease(medicalDisease);

        // 저장된 엔티티가 null이 아님을 확인
        assertNotNull(savedMedicalDisease);
        assertEquals("순환계통(심장)", savedMedicalDisease.getDiseaseNames().getName());
    }
}