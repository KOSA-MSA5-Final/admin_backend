package com.example.demo.domains.disease.repository.querydsl.customs;

import com.example.demo.domains.disease.entity.NewDisease;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 커스텀 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

public interface NewDiseaseRepositoryCustom {

    // 특정 조건에 따른 새로운 병명 조회
    List<NewDisease> findCustomNewDiseases(String condition);
}
