package com.example.demo.domains.member.repository.querydsl.impls;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.repository.ShoppingOrderRepository;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingOrderRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShoppingOrderRepositoryImpl implements ShoppingOrderRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<ShoppingOrder> findByisAllShipping(String status) {
        String jpql = "SELECT o FROM ShoppingOrder o WHERE o.isAllShipping = :status";

        return em.createQuery(jpql, ShoppingOrder.class)
                .setParameter("status", status)
                .getResultList();
    }
}
