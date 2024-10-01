package com.example.demo.domains.profile_medical.repository;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.AnimalRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 대분류 JPA 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 * 2024-10-01         김진석          중복 확인 jpa 추가
 */
public interface AnimalRepository extends JpaRepository<Animal, Long>, AnimalRepositoryCustom {

    // 대분류 동물 이름으로 중복 확인
    Boolean existsByName(String name);
}
