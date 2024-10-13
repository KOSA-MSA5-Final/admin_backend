package com.example.demo.domains.product.entity;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.profile_medical.entity.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DiseaseProduct")
@Getter
@Setter
public class DiseaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "disease_name_id")  // Product 외래 키
    private DiseaseNames diseaseNames;

    @ManyToOne
    @JoinColumn(name = "product_id")  // profile 외래 키
    private Product product;
}
