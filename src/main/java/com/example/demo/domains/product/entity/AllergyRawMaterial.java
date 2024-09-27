/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지-원료 join 엔티티
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */
package com.example.demo.domains.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AllergyRawmaterial")
@Getter
@Setter
public class AllergyRawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "allergy_id")  // Product 외래 키
    private Allergy allergy;

    @ManyToOne
    @JoinColumn(name = "rawmaterial_id")  // RawMaterial 외래 키
    private RawMaterial rawMaterial;
}
