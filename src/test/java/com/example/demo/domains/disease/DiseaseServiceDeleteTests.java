package com.example.demo.domains.disease;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
import com.example.demo.domains.disease.service.interfaces.NewDiseaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 삭제 서비스 테스트
 * <p>
 *
 * DATE            AUTHOR           NOTE
 * —————————————————————————————
 * 2024-09-24       김진석         최초 생성
 */

@SpringBootTest
@ActiveProfiles("test")
public class DiseaseServiceDeleteTests {

    @Autowired
    private DiseaseNamesService diseaseNamesService;
    @Autowired
    private DiseaseSubService diseaseSubService;
    @Autowired
    private NewDiseaseService newDiseaseService;

    private DiseaseNames savedDiseaseNames;
    private DiseaseSub savedDiseaseSub;
    private NewDisease savedNewDisease;

    @BeforeEach
    public void setupData() {
        // 대분류 병명을 기존 데이터에서 조회
        savedDiseaseNames = diseaseNamesService.findDiseaseByName("소화기계통");
        assertNotNull(savedDiseaseNames); // 대분류 병명이 존재하는지 확인

        // 소분류 병명과 새로운 병명도 조회
        savedDiseaseSub = diseaseSubService.findAllByName("급성 위장염").stream().findFirst().orElse(null);
        savedNewDisease = newDiseaseService.findAllByNewDiseaseName("소화흡수장애").stream().findFirst().orElse(null);

        assertNotNull(savedDiseaseNames); // 대분류 병명이 존재하는지 확인
        assertNotNull(savedDiseaseSub); // 소분류 병명이 존재하는지 확인
        assertNotNull(savedNewDisease); // 새로운 병명이 존재하는지 확인
    }

    @Test
    @Transactional
    @DisplayName("대분류 병명 삭제 테스트")
    public void testDeleteDiseaseNames() {
        // 대분류 병명 삭제
        Boolean isDeleted = diseaseNamesService.deleteDiseaseById(savedDiseaseNames.getId());

        // 삭제 성공 여부 확인
        assertTrue(isDeleted, "대분류 병명 삭제가 실패했습니다.");

        // 삭제 후 대분류 병명이 없는지 확인
        DiseaseNames deletedDiseaseNames = diseaseNamesService.findDiseaseByName("소화기계통");
        assertNull(deletedDiseaseNames); // 대분류 병명이 삭제되었는지 확인
    }

    @Test
    @Transactional
    @DisplayName("소분류 병명 삭제 테스트")
    public void testDeleteDiseaseSub() {
        // 소분류 병명 삭제
        Boolean isDeleted = diseaseSubService.deleteDiseaseSubById(savedDiseaseSub.getId());

        // 삭제 성공 여부 확인
        assertTrue(isDeleted, "대분류 병명 삭제가 실패했습니다.");

        // 삭제 후 소분류 병명이 없는지 확인
        DiseaseSub deletedDiseaseSub = diseaseSubService.findAllByName("급성 위장염").stream().findFirst().orElse(null);
        assertNull(deletedDiseaseSub); // 소분류 병명이 삭제되었는지 확인
    }

    @Test
    @Transactional
    @DisplayName("새로운 병명 삭제 테스트")
    public void testDeleteNewDisease() {
        // 새로운 병명 삭제
        Boolean isDeleted = newDiseaseService.deleteNewDiseaseById(savedNewDisease.getId());

        // 삭제 성공 여부 확인
        assertTrue(isDeleted, "대분류 병명 삭제가 실패했습니다.");

        // 삭제 후 새로운 병명이 없는지 확인
        NewDisease deletedNewDisease = newDiseaseService.findAllByNewDiseaseName("소화흡수장애").stream().findFirst().orElse(null);
        assertNull(deletedNewDisease); // 새로운 병명이 삭제되었는지 확인
    }
}
