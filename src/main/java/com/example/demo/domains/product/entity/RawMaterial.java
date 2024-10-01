/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 원료 엔티티
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 * 2024-10-01         윤다희          join 로 변경
 */
package com.example.demo.domains.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rawmaterial_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Product 외래 키
    private Product product;

    @ManyToOne
    @JoinColumn(name = "allergy_id")  // RawMaterial 외래 키
    private Allergy allergy;

}
