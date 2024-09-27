/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 영양성분 내용 엔티티
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
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int id;

    @Column(name = "ingredient_name")
    private String name;

    @Column(name = "ingredient_percentage")
    private String percentage;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Product 외래 키
    private Product product;  // Product와의 다대일 관계
}
