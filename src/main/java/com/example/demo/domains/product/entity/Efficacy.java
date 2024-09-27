/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 기능 내용 엔티티
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
public class Efficacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "efficacy_id")
    private int id;

    @Column(name = "efficacy_details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "product_id")  // Product 외래 키
    private Product product;  // Product와의 다대일 관계
}
