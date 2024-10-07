package com.example.demo.domains.disease.repository.querydsl.impls;

import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseSubProfileRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiseaseSubProfileRepositoryImpl implements DiseaseSubProfileRepositoryCustom {

    private final EntityManager em;
}
