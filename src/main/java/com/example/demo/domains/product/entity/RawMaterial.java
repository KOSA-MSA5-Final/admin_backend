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
    private int id;

    @Column(name = "rawmaterial_name")
    private String name;

    @Column(name = "rawmaterial_type")
    private String type;

    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private List<RawMaterialsProduct> products;  // ProductRawMaterial과 1대다 관계

    @OneToMany(mappedBy = "rawMaterial", cascade = CascadeType.ALL)
    private List<AllergyRawMaterial> allergys;  // AllergyRawMaterial과 1대다 관계

}
