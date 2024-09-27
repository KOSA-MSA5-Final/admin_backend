package com.example.demo.domains.profile_medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 소분류 Entity
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Entity
@Getter
@Setter
public class AnimalDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalDetail_id")
    private long id;

    @Column(name = "animalDetail_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
