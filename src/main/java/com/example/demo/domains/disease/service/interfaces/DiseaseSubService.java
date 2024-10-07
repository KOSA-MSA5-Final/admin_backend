package com.example.demo.domains.disease.service.interfaces;

import com.example.demo.domains.disease.entity.DiseaseSub;

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

public interface DiseaseSubService {

    // 전체 소분류 병명 조회
    List<DiseaseSub> findAllDiseaseSubs();

    // 대분류 ID로 소분류 병명 조회
    List<DiseaseSub> findSubDiseasesByDiseaseNameId(Long diseaseNameId);

    // 이름으로 소분류 병명 조회
    List<DiseaseSub> findAllByName(String name);

    // 소분류 병명 추가/업데이트
    DiseaseSub saveDiseaseSub(DiseaseSub diseaseSub);

    // 소분류 병명 삭제
    Boolean deleteDiseaseSubById(Long id);

//    // 커스텀 조회 메서드
//    List<DiseaseSub> findCustomDiseaseSubs(String condition);
}
