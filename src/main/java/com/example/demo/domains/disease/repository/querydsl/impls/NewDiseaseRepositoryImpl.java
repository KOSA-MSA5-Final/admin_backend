package com.example.demo.domains.disease.repository.querydsl.impls;

import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.repository.querydsl.customs.NewDiseaseRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 관련 커스텀 repository 구현체
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@RequiredArgsConstructor
public class NewDiseaseRepositoryImpl implements NewDiseaseRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<NewDisease> findCustomNewDiseases(String condition) {
        String jpql = "SELECT nd FROM NewDisease nd WHERE nd.name LIKE :condition";
        TypedQuery<NewDisease> query = em.createQuery(jpql, NewDisease.class);
        query.setParameter("condition", "%" + condition + "%");

        return query.getResultList();
    }
}
