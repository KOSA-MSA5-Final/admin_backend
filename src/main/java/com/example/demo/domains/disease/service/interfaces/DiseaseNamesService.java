package com.example.demo.domains.disease.service.interfaces;

import com.example.demo.domains.disease.entity.DiseaseNames;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 service interface (기본 CRUD, 커스텀)
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

public interface DiseaseNamesService {

    // 전체 대분류 병명 조회
    List<DiseaseNames> findAllDiseases();

    // 대분류 병명으로 조회
    DiseaseNames findDiseaseByName(String diseaseName);

    // 대분류 병명 추가
    DiseaseNames saveDisease(DiseaseNames diseaseNames);

    // 대분류 병명 삭제
    Boolean deleteDiseaseById(Long id);

    // 커스텀 조회 메서드
    List<DiseaseNames> findCustomDiseaseNames(String condition);
}
