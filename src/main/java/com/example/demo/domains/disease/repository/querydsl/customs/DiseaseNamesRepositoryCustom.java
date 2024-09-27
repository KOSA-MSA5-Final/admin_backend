package com.example.demo.domains.disease.repository.querydsl.customs;

import com.example.demo.domains.disease.entity.DiseaseNames;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 커스텀 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

public interface DiseaseNamesRepositoryCustom {

    // 복잡한 조건으로 대분류 병명을 검색하는 커스텀 메서드
    List<DiseaseNames> findCustomDiseaseNames(String condition);
}
