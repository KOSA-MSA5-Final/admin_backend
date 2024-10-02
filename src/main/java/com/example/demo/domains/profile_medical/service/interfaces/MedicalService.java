package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Profile;

import java.util.Date;
import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 기록 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface MedicalService {
    List<Medical> getByProfile(Profile profile);
    List<Medical> getByVisitDate(Date visitDate);
    List<Medical> getMedicalsByProfileId(Long profileId);
    List<Medical> getMedicalsByProfileID_DESCByVisitDate(Long profileId);
    List<Medical> getAllMedicalsByVisitDate(Date visitDate);

    List<Medical> getAllMedicals();
    Medical save(Date utcDate, String receipt_img, String object, Profile profile, Long totalCost);
    Boolean delete(Medical medical);
}
