package com.example.demo.domains.profile_medical.repository.querydsl.customs;

import com.example.demo.domains.profile_medical.entity.Medical;

import java.util.Date;
import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 기록 커스텀 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface MedicalRepositoryCustom {
    List<Medical> findMedicalsByProfileId(Long profileId);
    List<Medical> findMedicalsByProfileID_DESCByVisitDate(Long profileId);
    List<Medical> findAllMedicalsByVisitDate(Date visitDate);
}
