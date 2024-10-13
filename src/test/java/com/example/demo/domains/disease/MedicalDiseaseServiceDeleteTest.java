//package com.example.demo.domains.disease;
//
//import com.example.demo.domains.disease.entity.DiseaseNames;
//import com.example.demo.domains.disease.entity.MedicalDisease;
//import com.example.demo.domains.disease.service.interfaces.MedicalDiseaseService;
//import com.example.demo.domains.profile_medical.entity.Medical;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class MedicalDiseaseServiceDeleteTest {
//
//    @Autowired
//    private MedicalDiseaseService medicalDiseaseService;
//
//    private MedicalDisease medicalDisease;
//
//    @BeforeEach
//    public void setUp() {
//        // 병명 대분류
//        DiseaseNames diseaseNames = new DiseaseNames();
//        diseaseNames.setName("비대성심근증");
//
//        // 진료 기록
//        Medical medical = new Medical();
//        medical.setVisitDate(new Date());
//
//        // MedicalDisease 생성
//        medicalDisease = new MedicalDisease();
//        medicalDisease.setDiseaseNames(diseaseNames);
//        medicalDisease.setMedical(medical);
//        medicalDisease.setProgressStatus("T");
//        medicalDisease.setDiagnosisDate(new Date());
//
//        // MedicalDisease 저장
//        medicalDiseaseService.createMedicalDisease(medicalDisease);
//    }
//
//    @Test
//    @Transactional
//    public void testDeleteMedicalDisease() {
//        // 삭제 시도
//        Boolean isDeleted = medicalDiseaseService.deleteMedicalDiseaseById(medicalDisease.getId());
//
//        // 삭제가 성공적으로 이루어졌는지 확인
//        assertTrue(isDeleted);
//
//        // 이미 삭제된 MedicalDisease는 다시 삭제할 수 없으므로 false 반환
//        Boolean isDeletedAgain = medicalDiseaseService.deleteMedicalDiseaseById(medicalDisease.getId());
//        assertFalse(isDeletedAgain);
//    }
//}