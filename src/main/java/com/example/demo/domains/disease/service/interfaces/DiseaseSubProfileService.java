package com.example.demo.domains.disease.service.interfaces;

import com.example.demo.domains.disease.dto.DiseaseSubProfileDTO;
import com.example.demo.domains.profile_medical.entity.Profile;

import java.util.List;

public interface DiseaseSubProfileService {
    List<DiseaseSubProfileDTO> getDiseaseSubProfilesByProfile(Profile profile);
}