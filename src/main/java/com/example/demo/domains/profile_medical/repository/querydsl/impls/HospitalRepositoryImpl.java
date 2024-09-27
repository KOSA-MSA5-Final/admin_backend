package com.example.demo.domains.profile_medical.repository.querydsl.impls;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.HospitalRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 병원 커스텀 레포지토리 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@RequiredArgsConstructor
public class HospitalRepositoryImpl implements HospitalRepositoryCustom {
    private final EntityManager em;

    @Override
    public List<Hospital> findOurHospitals() {

        String jpql = "SELECT h FROM Hospital h WHERE h.is_ours = 'T'";

        TypedQuery<Hospital> query = em.createQuery(jpql, Hospital.class);
        return query.getResultList();
    }

    @Override
    public List<Hospital> findOurHospitalsByCurrentLocation(String location) {
        String jpql = "SELECT h FROM Hospital h WHERE h.is_ours = 'T' AND h.address LIKE :location";

        TypedQuery<Hospital> query = em.createQuery(jpql, Hospital.class);
        query.setParameter("location", "%" + location + "%"); // 위치 기반 파라미터 설정
        return query.getResultList();
    }

}
