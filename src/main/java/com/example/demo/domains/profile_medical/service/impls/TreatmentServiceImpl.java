package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.repository.TreatmentRepository;
import com.example.demo.domains.profile_medical.service.interfaces.TreatmentService;
import com.example.demo.domains.profile_medical.entity.Treatment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료 목록 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {
    private final TreatmentRepository treatmentRepository;

    @Override
    public List<Treatment> getTreatmentsByMedical(Medical medical) {
        return treatmentRepository.findByMedical(medical);
    }

    @Override
    public List<Treatment> getTreatmentsByHospital(Hospital hospital) {
        return treatmentRepository.findByHospital(hospital);
    }

    @Override
    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    @Override
    public Treatment save(String name, Long price, Medical medical, Hospital hospital) {
        Treatment treatment = new Treatment();
        treatment.setName(name);
        treatment.setPrice(price);
        treatment.setMedical(medical);
        treatment.setHospital(hospital);
        return treatmentRepository.save(treatment);
    }

    @Override
    public Boolean delete(Treatment treatment) {
        try{
            treatmentRepository.delete(treatment);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
