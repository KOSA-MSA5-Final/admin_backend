package com.example.demo.domains.profile_medical.repository.querydsl.customs;

import com.example.demo.domains.profile_medical.entity.Hospital;

import java.util.List;
import java.util.Optional;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 병원 커스텀 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface HospitalRepositoryCustom {
    List<Hospital> findOurHospitals();
    List<Hospital> findOurHospitalsByCurrentLocation(String location);

}
