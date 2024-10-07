package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ReceiptDTO {
    private List<MedicalDTO> medicalDTOs;
    private String reg_num;
    private String hospital_name;
    private String hospital_address;
    private String hospital_phoneNum;
    private String visitDate;
    private Integer totalCost;

//    public ReceiptDTO(List<MedicalDTO> medicalDTOs, String reg_num, String hospital_name, String hospital_address, String hospital_phoneNum, String visitDate, String totalCost) {
//        this.medicalDTOs = medicalDTOs;
//        this.reg_num = reg_num;
//        this.hospital_name = hospital_name;
//        this.hospital_address = hospital_address;
//        this.hospital_phoneNum = hospital_phoneNum;
//        this.visitDate = visitDate;
//        this.totalCost = Integer.valueOf(totalCost);
//    }
}
