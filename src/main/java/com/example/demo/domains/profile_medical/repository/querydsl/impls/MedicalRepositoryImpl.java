package com.example.demo.domains.profile_medical.repository.querydsl.impls;

import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.MedicalRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 기록 커스텀 레포지토리 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@RequiredArgsConstructor
public class MedicalRepositoryImpl implements MedicalRepositoryCustom {
    private final EntityManager em;

    @Override
    public List<Medical> findMedicalsByProfileId(Long profileId) {
        String jpql = "SELECT m FROM Medical m WHERE m.profile.id = :profileId";
        TypedQuery<Medical> query = em.createQuery(jpql, Medical.class);
        query.setParameter("profileId", profileId);
        return query.getResultList();
    }

    @Override
    public List<Medical> findMedicalsByProfileID_DESCByVisitDate(Long profileId) {
        String jpql = "SELECT m FROM Medical m WHERE m.profile.id = :profileId ORDER BY m.visitDate DESC";
        TypedQuery<Medical> query = em.createQuery(jpql, Medical.class);
        query.setParameter("profileId", profileId);
        return query.getResultList();
    }

    @Override
    public List<Medical> findAllMedicalsByVisitDate(Date visitDate) {
        // visitDate는 연/년+월/년+월+일 세가지 유형 어떤 것이든 들어올 수 있다. 무엇이든 visitDate의 (년/월/일 기준) Medical들을 리턴해주는 함수이다.
        // Date를 String으로 변환하는 패턴 설정
        String yearPattern = "%tY";   // 연도만 (예: "2024")
        String monthPattern = "%tY-%tm"; // 연도-월 (예: "2024-09")
        String dayPattern = "%tY-%tm-%td"; // 연도-월-일 (예: "2024-09-24")

        // 기본적으로 연도-월-일 패턴으로 변환
        String datePattern = String.format(dayPattern, visitDate);

        // 해당 패턴에 따라 길이를 비교하여 연도만, 연도+월, 연도+월+일로 나누어 설정
        if (datePattern.length() == 10) {
            // 연도-월-일 (예: "2024-09-24")
            datePattern = String.format(dayPattern, visitDate);
        } else if (datePattern.length() == 7) {
            // 연도-월 (예: "2024-09")
            datePattern = String.format(monthPattern, visitDate);
        } else if (datePattern.length() == 4) {
            // 연도만 (예: "2024")
            datePattern = String.format(yearPattern, visitDate);
        }

        // JPQL 쿼리 작성
        String jpql = "SELECT m FROM Medical m WHERE FUNCTION('FORMAT', m.visitDate, 'yyyy-MM-dd') LIKE :visitDatePattern";
        TypedQuery<Medical> query = em.createQuery(jpql, Medical.class);
        query.setParameter("visitDatePattern", datePattern + "%");

        return query.getResultList();
    }
}
