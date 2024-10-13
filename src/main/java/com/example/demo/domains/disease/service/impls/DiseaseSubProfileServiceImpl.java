package com.example.demo.domains.disease.service.impls;

import com.example.demo.domains.admin.dto.AnimalDiseaseDTO;
import com.example.demo.domains.disease.dto.DiseaseSubProfileDTO;
import com.example.demo.domains.disease.entity.DiseaseSubProfile;
import com.example.demo.domains.disease.repository.DiseaseSubProfileRepository;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubProfileService;
import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<AnimalDiseaseDTO> getAnimalTypeCountByDiseaseSub() {
        List<DiseaseSubProfile> results = diseaseSubProfileRepository.findAll();

        List<AnimalDiseaseDTO> dtoList = new ArrayList<>();

        for(DiseaseSubProfile re : results){
            AnimalDiseaseDTO dt = new AnimalDiseaseDTO();
            dt.setAnimalName(re.getProfile().getAnimalDetail().getAnimal().getName());
            dt.setDiseaseName(re.getDiseaseSub().getName());
            dtoList.add(dt); // 리스트에 추가
        }
        // 결과 데이터를 AnimalDiseaseDTO로 변환
        return dtoList;
    }
}