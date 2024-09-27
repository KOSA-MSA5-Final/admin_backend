package com.example.demo.domains.member.entity;

import com.example.demo.domains.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * author : 나선주
 * date : 2024-09-24
 * description :  주문과 상품 join table
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
public class ShoppingOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="shoppingOrder_id")
    private ShoppingOrder shoppingOrder;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Date createdAt;//각상품별구매날짜

    private long quantity;

    private String shippingStatus;

    public void updateQuantity(long quantity) {
        this.quantity = quantity;
    }

}
