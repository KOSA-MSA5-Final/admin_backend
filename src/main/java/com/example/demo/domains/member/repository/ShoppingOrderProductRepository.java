package com.example.demo.domains.member.repository;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingOrderProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingOrderProductRepository extends JpaRepository<ShoppingOrderProduct, Long>, ShoppingOrderProductRepositoryCustom {
    List<ShoppingOrderProduct> findByShoppingOrder(ShoppingOrder shoppingOrder);
}
