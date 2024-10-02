package com.example.demo.domains.disease.repository;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseNamesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 기본 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */


public interface DiseaseNamesRepository extends JpaRepository<DiseaseNames, Long>, DiseaseNamesRepositoryCustom {

    // 기본적으로 대분류 병명을 이름으로 검색
    DiseaseNames findByName(String name);

    // 이름을 기준으로 중복 확인 메서드
    Boolean existsByName(String name);
}
