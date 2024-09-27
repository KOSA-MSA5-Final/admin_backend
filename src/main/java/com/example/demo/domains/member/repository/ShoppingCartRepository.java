package com.example.demo.domains.member.repository;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.ShoppingCart;
import com.example.demo.domains.member.repository.querydsl.customs.ShoppingCartRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : ShoppingCartRepository
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>, ShoppingCartRepositoryCustom {
    ShoppingCart findByMember(Member member);

}
