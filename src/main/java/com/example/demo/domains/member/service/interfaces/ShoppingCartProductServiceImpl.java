package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.ShoppingCart;
import com.example.demo.domains.member.entity.ShoppingCartProduct;
import com.example.demo.domains.member.repository.ShoppingCartProductRepository;
import com.example.demo.domains.member.service.impls.ShoppingCartProductService;
import com.example.demo.domains.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
 * 2024-09-24       나선주          메소드(조회, 삭제, 생성) 생성
 */
@Service
public class ShoppingCartProductServiceImpl implements ShoppingCartProductService {
    @Autowired
    private ShoppingCartProductRepository shoppingCartProductRepository;

    @Override
    public Long savePrdQuantityToCart(ShoppingCartProduct shoppingCartProduct) {
        ShoppingCartProduct save = shoppingCartProductRepository.save(shoppingCartProduct);
        return save.getQuantity();
    }

    @Override
    public Long findPrdQuantityFromCart(ShoppingCartProduct shoppingCartProduct) {
        long id = shoppingCartProduct.getId();
        Optional<ShoppingCartProduct> byId = shoppingCartProductRepository.findById(id);
        return byId.get().getQuantity();
    }

    @Override
    public List<Product> findProductsFromCart(ShoppingCart shoppingCart) {
        List<Product> products = new ArrayList<>();
        List<ShoppingCartProduct> byShoppingCart = shoppingCartProductRepository.findByShoppingCart(shoppingCart);
        for (ShoppingCartProduct shoppingCartProduct : byShoppingCart) {
            products.add(shoppingCartProduct.getProduct());
        }
        return products;
    }

    @Override
    public Boolean updatePrdQuantityFromCart(Long shoppingCartProductId, long newQuantity) {
        try{
            ShoppingCartProduct cartProduct = shoppingCartProductRepository.findById(shoppingCartProductId)
                    .orElseThrow(() -> new RuntimeException("nsj: ShoppingCartProduct not found"));

            cartProduct.updateQuantity(newQuantity); // quantity 필드를 업데이트
            // 트랜잭션이 끝나면 자동으로 DB에 반영됨
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteProductFromCart(ShoppingCartProduct shoppingCartProduct) {
        try {
            shoppingCartProductRepository.delete(shoppingCartProduct);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
