/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 내용 이미지 저장 엔티티
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
public class ProductImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productImg_id")
    private long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Product 외래 키
    private Product product;  // Product와의 다대일 관계
}
