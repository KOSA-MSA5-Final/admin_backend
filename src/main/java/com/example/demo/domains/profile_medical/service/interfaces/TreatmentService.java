package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Treatment;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 목록 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface TreatmentService {
    List<Treatment> getTreatmentsByMedical(Medical medical);
    List<Treatment> getTreatmentsByHospital(Hospital hospital);
    List<Treatment> getAllTreatments();

    Treatment save(String name, Long price, Medical medical, Hospital hospital);
    Boolean delete(Treatment treatment);
}
