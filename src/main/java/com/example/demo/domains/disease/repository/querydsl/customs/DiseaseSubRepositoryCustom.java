package com.example.demo.domains.disease.repository.querydsl.customs;

import com.example.demo.domains.disease.entity.DiseaseSub;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 소분류 커스텀 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

public interface DiseaseSubRepositoryCustom {
    // 커스텀 쿼리 또는 추가적인 조회 로직
    List<DiseaseSub> findCustomDiseaseSubs(String condition);
}
