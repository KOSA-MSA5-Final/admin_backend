package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.MedicalHospital;
import com.example.demo.domains.profile_medical.service.interfaces.MedicalHospitalService;
import com.example.demo.domains.profile_medical.repository.MedicalHospitalRepository;
import com.example.demo.domains.profile_medical.repository.MedicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료기록-병원 관계 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class MedicalHospitalServiceImpl implements MedicalHospitalService {
    private final MedicalHospitalRepository medicalHospitalRepository;
    private final MedicalRepository medicalRepository;

    @Override
    public List<MedicalHospital> getAllMedicalHospitals() {
        return medicalHospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalByMedical(Medical medical) {
        return medicalHospitalRepository.findHospitalByMedical(medical);
    }

    @Override
    public Hospital getHospitalByMedicalId(Long id) {
        Medical medical = medicalRepository.findById(id).orElse(null);
        if (medical != null){
            return medicalHospitalRepository.findHospitalByMedical(medical);
        } else {
            return null;
        }
    }

    @Override
    public List<Medical> getAllMedicalsByHospital(Hospital hospital) {
        return medicalHospitalRepository.findMedicalByHospital(hospital);
    }

    @Override
    public MedicalHospital save(Medical medical, Hospital hospital) {
        MedicalHospital medicalHospital = new MedicalHospital();
        medicalHospital.setHospital(hospital);
        medicalHospital.setMedical(medical);
        return medicalHospitalRepository.save(medicalHospital);
    }

    @Override
    public Boolean deleteMedicalHospital(MedicalHospital medicalHospital) {
        try{
            medicalHospitalRepository.delete(medicalHospital);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
