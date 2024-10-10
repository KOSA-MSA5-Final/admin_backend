package com.example.demo.domains.member.repository.querydsl.customs;

import com.example.demo.domains.member.entity.ShoppingOrder;

import java.util.List;

public interface ShoppingOrderRepositoryCustom {
    List<ShoppingOrder> findByisAllShipping(String status);
}
