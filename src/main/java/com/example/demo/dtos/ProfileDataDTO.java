package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProfileDataDTO {
    private String petName;
    private String petType;
    private String petGender;
    private Date petBirthDate;
    private String petIsNeutered;
    private String petWillNeutered;
    private List<String> selectedAllergies;
    private Map<String, Object> isDisease;
    private Map<String, Object> checkedDiseases;
    private String username;
    private List<Map<String, String>> etcDisease;
}
