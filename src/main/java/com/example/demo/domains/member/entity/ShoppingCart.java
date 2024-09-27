package com.example.demo.domains.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : 장바구니
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
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shoppingCart_id")
    private long id;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartProduct> cartProductList;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member;

    private long totalPrice;

    private int itemCount;

   /* @OneToMany
    @JoinColumn(name="product_id")
    private List<Product> products;*/
}
