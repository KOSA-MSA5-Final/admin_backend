package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.interfaces.HospitalService;
import com.example.demo.domains.profile_medical.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 병원 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public Hospital saveFromUser(Long reg_num, String name, String doctorName, String address) {
        Optional<Hospital> h = hospitalRepository.findById(reg_num);
        if (!h.isPresent()) {
            Hospital hospital = new Hospital();
            hospital.setId(reg_num);
            hospital.setName(name);
            hospital.setDoctor(doctorName);
            hospital.setAddress(address);
            hospital.setIs_ours("F");
            return hospitalRepository.save(hospital);
        } else {
            return null;
        }
    }

    @Override
    public Hospital saveByAdmin(Long reg_num, String name, String doctorName, String address) {
        Optional<Hospital> h = hospitalRepository.findById(reg_num);
        if (!h.isPresent()) {
            Hospital hospital = new Hospital();
            hospital.setId(reg_num);
            hospital.setName(name);
            hospital.setDoctor(doctorName);
            hospital.setAddress(address);
            hospital.setIs_ours("T");
            return hospitalRepository.save(hospital);
        } else {
            return null;
        }
    }

    @Override
    public Boolean delete(Hospital hospital) {
        try{
            hospitalRepository.delete(hospital);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> getOurHospitalsByCurrentLocation(String location) {
        return hospitalRepository.findOurHospitalsByCurrentLocation(location);
    }

    @Override
    public List<Hospital> getAllOurHospitals() {
        return hospitalRepository.findOurHospitals();
    }
}
