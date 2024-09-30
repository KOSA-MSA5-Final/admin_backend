package com.example.demo.domains.admin.entitiy;

import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.entity.NewDisease;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_password")
    private String password;

}
