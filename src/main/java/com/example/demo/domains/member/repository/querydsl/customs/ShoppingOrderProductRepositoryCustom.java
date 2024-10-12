package com.example.demo.domains.member.repository.querydsl.customs;

public interface ShoppingOrderProductRepositoryCustom {
    long countByShippingStatus(String status);
}
