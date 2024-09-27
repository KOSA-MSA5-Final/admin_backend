package com.example.demo.domains.disease.repository;

import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseSubRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 소분류 기본 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */


public interface DiseaseSubRepository extends JpaRepository<DiseaseSub, Long>, DiseaseSubRepositoryCustom {

    // 특정 대분류에 속한 모든 소분류 병명을 조회 (대분류 ID 기준)
    List<DiseaseSub> findAllByDiseaseNames_Id(Long id);

    // 소분류 병명을 이름으로 조회
    List<DiseaseSub> findAllByName(String name);
}


