package com.example.demo.domains.profile_medical.repository;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.AnimalDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 소분류 JPA 레포지토리

 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 * 2024-10-01         김진석          중복 확인 jpa 추가
 */
public interface AnimalDetailRepository extends JpaRepository<AnimalDetail, Long>, AnimalDetailRepositoryCustom {

    // 소분류 이름과 대분류 동물로 중복 확인
    Boolean existsByNameAndAnimal(String name, Animal animal);

    List<AnimalDetail> findByAnimal(Animal animal);
}
