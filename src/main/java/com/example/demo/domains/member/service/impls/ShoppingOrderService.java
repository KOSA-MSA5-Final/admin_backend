package com.example.demo.domains.member.service.impls;

import com.example.demo.domains.member.entity.ShoppingOrder;

import java.util.List;

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
public interface ShoppingOrderService {
    //구매 생성
    ShoppingOrder saveOrder(ShoppingOrder shoppingOrder);

    //전체 구매목록 조회
    List<ShoppingOrder> findAllOrders();

    //구매 삭제
    Boolean deleteOrder(ShoppingOrder shoppingOrder);
}
