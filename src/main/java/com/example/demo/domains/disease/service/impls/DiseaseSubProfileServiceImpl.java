package com.example.demo.domains.disease.service.impls;

import com.example.demo.domains.disease.dto.DiseaseSubProfileDTO;
import com.example.demo.domains.disease.entity.DiseaseSubProfile;
import com.example.demo.domains.disease.repository.DiseaseSubProfileRepository;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubProfileService;
import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiseaseSubProfileServiceImpl implements DiseaseSubProfileService {
    private final DiseaseSubProfileRepository diseaseSubProfileRepository;

    @Override
    public List<DiseaseSubProfileDTO> getDiseaseSubProfilesByProfile(Profile profile) {
        List<DiseaseSubProfile> diseaseSubProfiles = diseaseSubProfileRepository.findByProfile(profile);

        // DiseaseSubProfile 엔티티를 DTO로 변환
        return diseaseSubProfiles.stream().map(diseaseSubProfile -> {
            DiseaseSubProfileDTO dto = new DiseaseSubProfileDTO();
            dto.setId(diseaseSubProfile.getId());
            dto.setDiseaseName(diseaseSubProfile.getDiseaseSub().getName());
            dto.setDiseaseSubCategory(diseaseSubProfile.getDiseaseSub().getName());
            return dto;
        }).collect(Collectors.toList());
    }
}