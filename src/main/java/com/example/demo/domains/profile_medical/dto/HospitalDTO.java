package com.example.demo.domains.profile_medical.dto;

import lombok.Data;

/**
 * 제휴 병원 데이터를 주고받기 위한 DTO
 */
@Data
public class HospitalDTO {
    private Long id; // 사업자 등록 번호
    private String name; // 병원 이름
    private String address; // 병원 주소
    private String doctor; // 의사 이름
    private String phoneNumber; // 전화번호
    private Boolean isOurs; // 제휴 여부
}
