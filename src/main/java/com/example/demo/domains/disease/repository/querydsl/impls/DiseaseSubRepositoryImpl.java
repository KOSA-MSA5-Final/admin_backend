package com.example.demo.domains.disease.repository.querydsl.impls;

import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseSubRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 소분류 관련 커스텀 repository 구현체
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@RequiredArgsConstructor
public class DiseaseSubRepositoryImpl implements DiseaseSubRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<DiseaseSub> findCustomDiseaseSubs(String condition) {
        String jpql = "SELECT ds FROM DiseaseSub ds WHERE ds.name LIKE :condition";
        TypedQuery<DiseaseSub> query = em.createQuery(jpql, DiseaseSub.class);
        query.setParameter("condition", "%" + condition + "%");

        return query.getResultList();
    }
}
