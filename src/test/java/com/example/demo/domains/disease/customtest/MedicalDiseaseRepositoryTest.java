//package com.example.demo.domains.disease.customtest;
//
//import com.example.demo.domains.disease.entity.DiseaseNames;
//import com.example.demo.domains.disease.entity.MedicalDisease;
//import com.example.demo.domains.disease.repository.MedicalDiseaseRepository;
//import com.example.demo.domains.profile_medical.entity.Medical;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class MedicalDiseaseRepositoryTest {
//
//    @Autowired
//    private MedicalDiseaseRepository medicalDiseaseRepository;
//
//    @BeforeEach
//    void setUp() {
//        // 테스트 데이터 생성 (병명, 진료 기록, MedicalDisease)
//        DiseaseNames diseaseNames = new DiseaseNames();
//        diseaseNames.setName("비대성심근증");
//
//        Medical medical = new Medical();
//        medical.setVisitDate(new Date());
//
//        MedicalDisease medicalDisease = new MedicalDisease();
//        medicalDisease.setDiseaseNames(diseaseNames);
//        medicalDisease.setMedical(medical);
//        medicalDisease.setProgressStatus("T");
//        medicalDisease.setDiagnosisDate(new Date());
//
//        medicalDiseaseRepository.save(medicalDisease);
//    }
//
//    @Test
//    void testFindByDiseaseNames_NameAndProgressStatus() {
//        List<MedicalDisease> result = medicalDiseaseRepository.findByDiseaseNames_NameAndProgressStatus("비대성심근증", "T");
//        assertFalse(result.isEmpty());
//        assertEquals("비대성심근증", result.get(0).getDiseaseNames().getName());
//    }
//}