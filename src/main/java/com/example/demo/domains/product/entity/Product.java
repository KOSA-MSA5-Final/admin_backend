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
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_maker")
    private String maker;

    @Column(name = "product_type")
    private String type;

    @Column(name = "product_price")
    private long price;

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

    // RawMaterial(원료) 다대다 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<RawMaterialsProduct> rawMaterials;  // ProductRawMaterial과 1대다 관계

    // ProductDetailImage 1대다 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetailImg> detailImgs;

    // ProductImage 1대다 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImg> images;

    // Ingredient 1대다 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Ingredient> ingerdients;

    // Efficacy 1대다 관계 설정
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Efficacy> efficacies;
}
