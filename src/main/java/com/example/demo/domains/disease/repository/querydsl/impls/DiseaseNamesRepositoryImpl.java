package com.example.demo.domains.disease.repository.querydsl.impls;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseNamesRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 관련 커스텀 repository 구현체
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@RequiredArgsConstructor
public class DiseaseNamesRepositoryImpl implements DiseaseNamesRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<DiseaseNames> findCustomDiseaseNames(String condition) {
        String jpql = "SELECT d FROM DiseaseNames d WHERE d.name LIKE :condition";
        TypedQuery<DiseaseNames> query = em.createQuery(jpql, DiseaseNames.class);
        query.setParameter("condition", "%" + condition + "%");

        return query.getResultList();
    }
}
