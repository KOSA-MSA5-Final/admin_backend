package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.MedicalHospital;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료기록-병원 관계 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface MedicalHospitalService {
    List<MedicalHospital> getAllMedicalHospitals();
    Hospital getHospitalByMedical(Medical medical);
    Hospital getHospitalByMedicalId(Long id);
    List<Medical> getAllMedicalsByHospital(Hospital hospital);
    MedicalHospital save(Medical medical, Hospital hospital);
    Boolean deleteMedicalHospital(MedicalHospital medicalHospital);

}
