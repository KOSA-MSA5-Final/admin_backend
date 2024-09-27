package com.example.demo.domains.profile_medical.repository.querydsl.impls;

import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.AnimalDetailRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 소분류 커스텀 레포지토리 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@RequiredArgsConstructor
public class AnimalDetailRepositoryImpl implements AnimalDetailRepositoryCustom {
    private final EntityManager em;

    @Override
    public Map<AnimalDetail, Integer> countProfilesByAnimalDetail() {
        String jpql = "SELECT ad, COUNT(p) " +
                "FROM Profile p " +
                "JOIN p.animalDetail ad " +
                "GROUP BY ad";

        List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();

        // 결과를 Map<AnimalDetail, Integer> 형태로 변환
        Map<AnimalDetail, Integer> profileCountsByAnimalDetail = new HashMap<>();
        for (Object[] result : results) {
            AnimalDetail animalDetail = (AnimalDetail) result[0];
            Long count = (Long) result[1];
            profileCountsByAnimalDetail.put(animalDetail, count.intValue());
        }
        return profileCountsByAnimalDetail;
    }

    @Override
    public List<AnimalDetail> findAnimalDetailByAnimalName(String animalName) {
        String jpql = "SELECT ad FROM AnimalDetail ad WHERE ad.animal.name = :animalName";
        TypedQuery<AnimalDetail> query = em.createQuery(jpql, AnimalDetail.class);
        query.setParameter("animalName", animalName);
        List<AnimalDetail> animalDetails = query.getResultList();
        return animalDetails;
    }
}
