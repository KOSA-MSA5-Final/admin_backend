package com.example.demo.domains.member.repository;

import com.example.demo.domains.member.entity.ShoppingCart;
import com.example.demo.domains.member.entity.ShoppingCartProduct;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingCartProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Long>, ShoppingCartProductRepositoryCustom {
    Long findQuantityByShoppingCart(ShoppingCart shoppingCart);
    Optional<ShoppingCartProduct> findById(Long id);
    List<ShoppingCartProduct> findByShoppingCart(ShoppingCart shoppingCart);
}
