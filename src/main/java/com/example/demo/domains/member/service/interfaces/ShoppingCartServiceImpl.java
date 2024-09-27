package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.ShoppingCart;
import com.example.demo.domains.member.repository.ShoppingCartRepository;
import com.example.demo.domains.member.service.impls.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * 2024-09-24       나선주          메소드(조회, 삭제, 생성) 생성
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart save = shoppingCartRepository.save(shoppingCart);
        return save;
    }

    @Override
    public ShoppingCart findShoppingCartByMember(Member member) {
        ShoppingCart s = shoppingCartRepository.findByMember(member);
        return s;
    }

    @Override
    public Boolean deleteShoppingCart(ShoppingCart shoppingCart) {
        try{
            shoppingCartRepository.delete(shoppingCart);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
