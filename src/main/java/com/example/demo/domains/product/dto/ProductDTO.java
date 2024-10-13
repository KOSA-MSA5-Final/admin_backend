package com.example.demo.domains.product.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String productName;
    private String productMaker;
    private String productType;
    private String productSubtype;
    private Long productPrice;
    private String animalName;
    private String productOrigin;
    private String productAllRawmaterial;
    private String productIngredient;
    private String productCalories;
    private String productWeight;
    private String productAge;
    private String productFunction;
    private List<Long> productAllergies; // 알레르지 ID 리스트
    private List<Long> diseaseNames; // 병명 ID 리스트
    private MultipartFile productMainImageUrls;
    private List<MultipartFile> productImageUrls; // 업로드된 이미지 파일들
    private List<MultipartFile> productDetailImageUrls; // 세부 이미지 파일들
}
