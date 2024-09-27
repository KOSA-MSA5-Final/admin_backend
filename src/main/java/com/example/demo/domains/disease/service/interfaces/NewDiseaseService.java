package com.example.demo.domains.disease.service.interfaces;

import com.example.demo.domains.disease.entity.NewDisease;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 service interface (기본 CRUD, 커스텀)
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

public interface NewDiseaseService {

    // 전체 새로운 병명 조회
    List<NewDisease> findAllNewDiseases();

    // 대분류 ID로 새로운 병명 조회
    List<NewDisease> findNewDiseasesByDiseaseNameId(Long diseaseNameId);

    // 이름으로 새로운 병명 조회
    List<NewDisease> findAllByNewDiseaseName(String name);

    // 새로운 병명 추가/업데이트
    NewDisease saveNewDisease(NewDisease newDisease);

    // 새로운 병명 삭제
    Boolean deleteNewDiseaseById(Long id);

    // 커스텀 조회 메서드
    List<NewDisease> findCustomNewDiseases(String condition);
}
