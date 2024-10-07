package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicalDTO {
    String medical_name;
    String medical_price;
    public MedicalDTO(String medical_name, String medical_price) {
        this.medical_name = medical_name;
        this.medical_price = medical_price;
    }
}
