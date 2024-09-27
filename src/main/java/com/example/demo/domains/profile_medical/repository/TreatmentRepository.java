package com.example.demo.domains.profile_medical.repository;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Treatment;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.TreatmentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 목록 JPA 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface TreatmentRepository extends JpaRepository<Treatment, Long>, TreatmentRepositoryCustom {
    List<Treatment> findByMedical(Medical medical);
    List<Treatment> findByHospital(Hospital hospital);
}
