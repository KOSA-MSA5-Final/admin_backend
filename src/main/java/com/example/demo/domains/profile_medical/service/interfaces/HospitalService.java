package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Hospital;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 병원 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface HospitalService {
    Hospital saveFromUser(Long reg_num, String name, String doctorName, String address);
    Hospital saveByAdmin(Long reg_num, String name, String doctorName, String address, String phonNum, String isOurs);
    Boolean delete(Hospital hospital);
    List<Hospital> getAll();
    List<Hospital> getOurHospitalsByCurrentLocation(String location);
    List<Hospital> getAllOurHospitals();
}
