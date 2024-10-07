package com.example.demo.domains.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileAllergyDTO {
    private long allergyId;
    private String allergyName;
    private String allergyType; // 대분류
}
