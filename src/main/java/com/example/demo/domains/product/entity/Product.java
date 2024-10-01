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

import com.example.demo.domains.profile_medical.entity.Animal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_maker")
    private String maker;

    @Column(name = "product_type")
    private String type;

    @Column(name = "product_price")
    private long price;

    // animal 과 다대 1 관계
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "product_origin")
    private String origin;

    @Column(name = "product_all_rawmaterial")
    private String all_rawmaterial;

    @Column(name = "product_ingredient")
    private String ingredient;

    @Column(name = "product_calories")
    private String calories;

    @Column(name = "product_weight")
    private String weight;

    @Column(name = "product_age_group")
    private String age_group;

    @Column(name = "product_function")
    private String function;

}
