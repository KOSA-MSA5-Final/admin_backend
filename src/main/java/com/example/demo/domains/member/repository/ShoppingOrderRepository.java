package com.example.demo.domains.member.repository;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingOrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : ShoppingOrderRepository
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */
public interface ShoppingOrderRepository extends JpaRepository<ShoppingOrder, Long>, ShoppingOrderRepositoryCustom {
    ShoppingOrder findByMember(Member member);

}
