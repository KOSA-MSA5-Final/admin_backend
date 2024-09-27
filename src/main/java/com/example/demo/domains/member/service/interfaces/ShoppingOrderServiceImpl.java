package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.repository.ShoppingOrderRepository;
import com.example.demo.domains.member.service.impls.ShoppingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
