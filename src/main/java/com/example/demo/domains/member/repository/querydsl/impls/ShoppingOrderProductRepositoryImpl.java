package com.example.demo.domains.member.repository.querydsl.impls;

import com.example.demo.domains.member.repository.ShoppingOrderProductRepository;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingOrderProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShoppingOrderProductRepositoryImpl implements ShoppingOrderProductRepositoryCustom {

    private final EntityManager em;

    @Override
    public long countByShippingStatus(String status) {
        String jpql = "SELECT COUNT(s) FROM ShoppingOrderProduct s WHERE s.shippingStatus = :status";
        return em.createQuery(jpql, Long.class)
                .setParameter("status", status)
                .getSingleResult();
    }
}
