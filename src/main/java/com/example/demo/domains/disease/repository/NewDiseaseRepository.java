package com.example.demo.domains.disease.repository;

import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.repository.querydsl.customs.NewDiseaseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 기본 repository
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@Repository
public interface NewDiseaseRepository extends JpaRepository<NewDisease, Long>, NewDiseaseRepositoryCustom {

    // 특정 대분류에 속한 모든 새로운 병명을 조회 (대분류 ID 기준)
    List<NewDisease> findAllByDiseaseNames_Id(Long id);

    // 새로운 병명을 이름으로 조회
    List<NewDisease> findAllByName(String name);
}


