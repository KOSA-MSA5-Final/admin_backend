package com.example.demo.domains.disease.repository.querydsl.impls;

import com.example.demo.domains.disease.entity.MedicalDisease;
import com.example.demo.domains.disease.repository.querydsl.customs.MedicalDiseaseRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MedicalDiseaseRepositoryImpl implements MedicalDiseaseRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<MedicalDisease> findCustomMedicalDiseases(String diseaseName, String progressStatus) {
        String jpql = "SELECT md FROM MedicalDisease md " +
                "JOIN md.diseaseNames dn " +
                "WHERE dn.name LIKE :diseaseName " +
                "AND md.progressStatus = :progressStatus";

        TypedQuery<MedicalDisease> query = entityManager.createQuery(jpql, MedicalDisease.class);
        query.setParameter("diseaseName", "%" + diseaseName + "%");
        query.setParameter("progressStatus", progressStatus);

        return query.getResultList();
    }
}