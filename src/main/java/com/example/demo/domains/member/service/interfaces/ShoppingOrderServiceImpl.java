package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.repository.ShoppingOrderRepository;
import com.example.demo.domains.member.service.impls.ShoppingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
@Service
public class ShoppingOrderServiceImpl implements ShoppingOrderService {
    @Autowired
    private ShoppingOrderRepository shoppingOrderRepository;

    @Override
    public ShoppingOrder saveOrder(ShoppingOrder shoppingOrder) {
        ShoppingOrder save = shoppingOrderRepository.save(shoppingOrder);
        return save;
    }

    @Override
    public List<ShoppingOrder> findAllOrders() {
        List<ShoppingOrder> all = shoppingOrderRepository.findAll();
        return all;
    }

    @Override
    public Boolean deleteOrder(ShoppingOrder shoppingOrder) {
        try{
            shoppingOrderRepository.delete(shoppingOrder);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public List<ShoppingOrder> findOrdersByStatus(String status) {
        return shoppingOrderRepository.findByisAllShipping(status);
    }

    public void updateOrderStatus(List<Long> orderIds, String newStatus) {
        // 주문 ID 리스트를 순회하며 상태를 업데이트
        for (Long orderId : orderIds) {
            Optional<ShoppingOrder> optionalOrder = shoppingOrderRepository.findById(orderId); // 주문을 찾아옴
            optionalOrder.ifPresent(order -> order.setIsAllShipping(newStatus)); // 새로운 상태로 업데이트
        }
    }
}
