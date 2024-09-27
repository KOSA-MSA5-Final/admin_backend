package com.example.demo.domains.profile_medical.repository.querydsl.impls;

import com.example.demo.domains.profile_medical.repository.querydsl.customs.TreatmentRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
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
public class TreatmentRepositoryImpl implements TreatmentRepositoryCustom {
    private final EntityManager em;

}
