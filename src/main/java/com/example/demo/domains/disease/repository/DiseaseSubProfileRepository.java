package com.example.demo.domains.disease.repository;

import com.example.demo.domains.disease.entity.DiseaseSubProfile;
import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseSubRepositoryCustom;
import com.example.demo.domains.profile_medical.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseSubProfileRepository extends JpaRepository<DiseaseSubProfile, Long>, DiseaseSubRepositoryCustom {
    DiseaseSubProfile save(DiseaseSubProfile diseaseSubProfile);
    List<DiseaseSubProfile> findByProfile(Profile profile);
}
