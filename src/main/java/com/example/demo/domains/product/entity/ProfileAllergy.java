package com.example.demo.domains.product.entity;

import com.example.demo.domains.profile_medical.entity.Profile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ProfileAllergy")
@Getter
@Setter
public class ProfileAllergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "allergy_id")  // Product 외래 키
    private Allergy allergy;

    @ManyToOne
    @JoinColumn(name = "profile_id")  // profile 외래 키
    private Profile profile;
}
