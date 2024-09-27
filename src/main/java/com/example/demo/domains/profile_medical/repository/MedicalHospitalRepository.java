package com.example.demo.domains.profile_medical.repository;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.MedicalHospital;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.MedicalHospitalRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료기록-병원 관계 JPA 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface MedicalHospitalRepository extends JpaRepository<MedicalHospital, Long>, MedicalHospitalRepositoryCustom {
//    MedicalHospital findByMedical(Medical medical);
    Hospital findHospitalByMedical(Medical medical);
    List<Medical> findMedicalByHospital(Hospital hospital);
}
