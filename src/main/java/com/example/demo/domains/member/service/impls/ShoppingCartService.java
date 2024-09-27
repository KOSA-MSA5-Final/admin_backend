package com.example.demo.domains.member.service.impls;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.ShoppingCart;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : MemberService
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 * 2024-09-24       나선주          method생성(CRD)
 */
public interface ShoppingCartService {
    //쇼핑카트를 생성
    ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);

    //쇼핑카트 조회
    ShoppingCart findShoppingCartByMember(Member member);

    //쇼핑카트를 제거
    Boolean deleteShoppingCart(ShoppingCart shoppingCart);

}
