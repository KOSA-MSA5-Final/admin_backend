package com.example.demo.domains.profile_medical.dto;

import com.example.demo.domains.disease.dto.DiseaseSubProfileDTO;
import com.example.demo.domains.product.dto.ProfileAllergyDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProfileDTO {
    private Long id;                    // Profile ID
    private String name;                // Profile name
    private String gender;              // Profile gender
    private Integer age;                // Profile age
    private Date birthday;              // Profile birthday
    private String isNeutered;          // Is neutered
    private String willNeutered;        // Will neutered
    private String pictureUrl;          // Profile picture URL
    private String isCurrent;           // Is current profile
    private String animalType;          // Animal type (from AnimalDetail entity)
    private String animalName;          // Animal name (from Animal entity)
    private List<ProfileAllergyDTO> allergies;  // 알러지원 리스트 추가
    private List<DiseaseSubProfileDTO> diseases; // 질병 리스트 추가
}
