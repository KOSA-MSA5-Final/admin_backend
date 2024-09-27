package com.example.demo.domains.member.service.impls;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.product.entity.Product;

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
public interface ShoppingOrderProductService {
    //구매목록에서 한 물품의 주문수량 등록
    Long savePrdQuantityToOrder(ShoppingOrderProduct shoppingOrderProduct);

    //구매에서 전체 물품 조회하기
    List<Product> findProductsByOrder(ShoppingOrder shoppingOrder);

    //구매목록에서 한 물품의 수량 가져오기
    Long findPrdQuantityFromOrder(ShoppingOrderProduct shoppingOrderProduct);

    //구매목록에서 한 물품의 수량 조절하기
    Boolean updatePrdQuantityFromOrder(Long shoppingOrderProductId, Long newQuantity);

    //구매목록에서 한 물품 제거하기
    Boolean deleteProductFromOrder(ShoppingOrderProduct shoppingOrderProduct);

}
