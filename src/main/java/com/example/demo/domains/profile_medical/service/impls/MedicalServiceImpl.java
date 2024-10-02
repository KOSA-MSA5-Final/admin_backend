package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.profile_medical.service.interfaces.MedicalService;
import com.example.demo.domains.profile_medical.repository.MedicalRepository;
import com.example.demo.util.UTCtoKorea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 진료기록 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicalService {
    private final MedicalRepository medicalRepository;

    @Override
    public List<Medical> getByProfile(Profile profile) {
        return medicalRepository.findByProfile(profile);
    }

    @Override
    public List<Medical> getByVisitDate(Date visitDate) {
        return medicalRepository.findByVisitDate(visitDate);
    }

    @Override
    public List<Medical> getMedicalsByProfileId(Long profileId) {
        return medicalRepository.findMedicalsByProfileId(profileId);
    }

    @Override
    public List<Medical> getMedicalsByProfileID_DESCByVisitDate(Long profileId) {
        return medicalRepository.findMedicalsByProfileID_DESCByVisitDate(profileId);
    }

    @Override
    public List<Medical> getAllMedicalsByVisitDate(Date visitDate) {
        return medicalRepository.findAllMedicalsByVisitDate(visitDate);
    }

    @Override
    public List<Medical> getAllMedicals() {
        return medicalRepository.findAll();
    }

    @Override
    public Medical save(Date utcDate, String receipt_img, String object, Profile profile, Long totalCost) {
        Medical medical = new Medical();
        medical.setProfile(profile);
        medical.setReceipt_img(receipt_img);
        medical.setVisitDate(UTCtoKorea.convertUTCToKoreanTime(utcDate));
        return medicalRepository.save(medical);
    }

    @Override
    public Boolean delete(Medical medical) {
        try {
            medicalRepository.delete(medical);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
