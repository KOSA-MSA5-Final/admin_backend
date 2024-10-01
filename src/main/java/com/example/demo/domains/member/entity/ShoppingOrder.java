package com.example.demo.domains.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : 주문
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
public class ShoppingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shoppingOrder_id")
    private long id;

    @Column
    private long totalPrice;

    @Column
    private String isAllShipping;//모든품목배송여부

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="myLocation_id")
    private MyLocation myLocation;

    @OneToMany(mappedBy="shoppingOrder")
    private List<ShoppingOrderProduct> orderProductList;

    private String receipient_name;

    private String receipient_telNum;

    private Date buyingDate;

    private String memo;


}
