//package com.example.demo.domains.disease;
//
//import com.example.demo.domains.disease.entity.DiseaseNames;
//import com.example.demo.domains.disease.entity.DiseaseSub;
//import com.example.demo.domains.disease.entity.NewDisease;
//import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
//import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
//import com.example.demo.domains.disease.service.interfaces.NewDiseaseService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * author : 김진석
// * date : 2024-09-24
// * description : 병명 생성 서비스 테스트
// * <p>
// *
// * DATE            AUTHOR           NOTE
// * —————————————————————————————
// * 2024-09-24       김진석         최초 생성
// */
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class DiseaseServiceCreateTests {
//
//    @Autowired
//    private DiseaseNamesService diseaseNamesService;
//    @Autowired
//    private DiseaseSubService diseaseSubService;
//    @Autowired
//    private NewDiseaseService newDiseaseService;
//
//    private DiseaseNames savedDiseaseNames;
//
//    // 기준이 되는 대분류 병명 추가
//    @BeforeEach
//    public void setupDiseaseNames() {
//        // 대분류 병명이 이미 저장되어 있는지 확인
//        DiseaseNames existingDiseaseNames = diseaseNamesService.findDiseaseByName("소화기계통");
//
//        if (existingDiseaseNames == null) {
//            // 없다면 추가
//            DiseaseNames diseaseNames = new DiseaseNames();
//            diseaseNames.setName("소화기계통");
//            savedDiseaseNames = diseaseNamesService.saveDisease(diseaseNames);
//        } else {
//            // 이미 존재하면 기존 데이터 사용
//            savedDiseaseNames = existingDiseaseNames;
//        }
//    }
//
//    @Test
//    @DisplayName("대분류 병명 생성되었는지 확인")
//    public void testAddDiseaseNames() {
//        // 대분류 병명이 이미 setupDiseaseNames()에서 설정되었으므로 중복 추가 X
//        assertNotNull(savedDiseaseNames.getId()); // ID가 생성되었는지 확인
//        assertEquals("소화기계통", savedDiseaseNames.getName()); // 저장된 이름 확인
//    }
//
//    @Test
//    @Transactional
//    @DisplayName("소분류 병명 추가하기")
//    public void testAddDiseaseSub() {
//        // 대분류 병명을 사용하여 소분류 병명 추가
//        DiseaseSub diseaseSub = new DiseaseSub();
//        diseaseSub.setName("급성 위장염");
//        diseaseSub.setDiseaseNames(savedDiseaseNames); // 대분류 병명과 연관 설정
//        DiseaseSub savedDiseaseSub = diseaseSubService.saveDiseaseSub(diseaseSub);
//
//        assertNotNull(savedDiseaseSub.getId()); // ID가 생성되었는지 확인
//        assertEquals("급성 위장염", savedDiseaseSub.getName()); // 저장된 소분류 병명 확인
//        assertEquals("소화기계통", savedDiseaseSub.getDiseaseNames().getName()); // 연관된 대분류 병명 확인
//    }
//
//    @Test
//    @Transactional
//    @DisplayName("새 병명 추가하기")
//    public void testAddNewDisease() {
//        // 대분류 병명을 사용하여 새 병명 추가
//        NewDisease newDisease = new NewDisease();
//        newDisease.setName("소화흡수장애");
//        newDisease.setDiseaseNames(savedDiseaseNames); // 대분류 병명과 연관 설정
//        NewDisease savedNewDisease = newDiseaseService.saveNewDisease(newDisease);
//
//        assertNotNull(savedNewDisease.getId()); // ID가 생성되었는지 확인
//        assertEquals("소화흡수장애", savedNewDisease.getName()); // 저장된 새로운 병명 확인
//        assertEquals("소화기계통", savedNewDisease.getDiseaseNames().getName()); // 연관된 대분류 병명 확인
//    }
//}
