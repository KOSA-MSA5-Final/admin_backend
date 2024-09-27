/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 내용 엔티티
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */
package com.example.demo.domains.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RawMaterialsProduct")
@Getter
@Setter
public class RawMaterialsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 주원료 여부
    private boolean is_primary;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Product 외래 키
    private Product product;

    @ManyToOne
    @JoinColumn(name = "rawmaterial_id")  // RawMaterial 외래 키
    private RawMaterial rawMaterial;
}
