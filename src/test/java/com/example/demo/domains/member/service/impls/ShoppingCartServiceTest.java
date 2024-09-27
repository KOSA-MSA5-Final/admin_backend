package com.example.demo.domains.member.service.impls;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.ShoppingCart;
import com.example.demo.domains.member.repository.MemberRepository;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ShoppingCartServiceTest {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);

        Product product = new Product();
        product.setId(1);
        product.setPrice(1000);
        productRepository.save(product);

        List<Product> products = productRepository.findAll();
        shoppingCart.setCartProductList(null);

        Member byEmail = memberRepository.findByEmail("nasnju@naver.com").get();
        shoppingCart.setMember(byEmail);
        ShoppingCart shoppingCart1 = shoppingCartService.saveShoppingCart(shoppingCart);
        assertNotNull(shoppingCart1);
    }

    @Test
    void findShoppingCartByMember() {
        Member byEmail = memberRepository.findByEmail("nasnju@naver.com").get();
        ShoppingCart shoppingCartByMember = shoppingCartService.findShoppingCartByMember(byEmail);
        assertNotNull(shoppingCartByMember);
    }

    @Test
    @Transactional
    void deleteShoppingCart() {
        Member byEmail = memberRepository.findByEmail("nasnju@naver.com").get();
        ShoppingCart shoppingCartByMember = shoppingCartService.findShoppingCartByMember(byEmail);
        Boolean b = shoppingCartService.deleteShoppingCart(shoppingCartByMember);
        assertTrue(b);
    }
}