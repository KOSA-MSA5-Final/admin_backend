package com.example.demo.domains.disease.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DiseaseSubProfileDTO {
    private Long id;                    // (DiseaseSubProfile entity id)
    private String diseaseName;         // (DiseaseNames entity name)
    private String diseaseSubCategory;  // (DiseaseSub entity name)
    private String progressStatus;      // (질병 진행 상태, T: 진행 중, F: 완료됨)
    private Date diagnosisDate;         // (진단 날짜)
}