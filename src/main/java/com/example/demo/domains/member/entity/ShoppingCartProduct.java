package com.example.demo.domains.member.entity;

import com.example.demo.domains.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : 장바구니와 상품 join table
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */
@Entity
@Getter
@Setter
public class ShoppingCartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="shoppingCart_id")
    private ShoppingCart shoppingCart;

    private long quantity;

    //quantity 업데이트 메서드
    public void updateQuantity(long quantity) {
        this.quantity = quantity;
    }
}
