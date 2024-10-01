package com.example.demo.domains.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : 대표배송지"들"
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
public class MyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="myLocation_id")
    private long id;

    private String address;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    private String isPrimary;

    @Column(name = "receipient_name")
    private String receipientName;

    @Column(name = "receipient_tellNum")
    private String receipientTellNum;
}
