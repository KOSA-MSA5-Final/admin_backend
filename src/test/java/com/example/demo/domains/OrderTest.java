package com.example.demo.domains;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.MyLocation;
import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.member.repository.MemberRepository;
import com.example.demo.domains.member.repository.MyLocationRepository;
import com.example.demo.domains.member.repository.ShoppingOrderProductRepository;
import com.example.demo.domains.member.repository.ShoppingOrderRepository;
import com.example.demo.domains.member.service.interfaces.ShoppingOrderProductServiceImpl;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class OrderTest {

    @Autowired
    private ShoppingOrderRepository shoppingOrderRepository;

    @Autowired
    private MyLocationRepository myLocationRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingOrderProductRepository shoppingOrderProductRepository;

    //private ShoppingOrderProductServiceImpl shoppingOrderProductServiceImpl;

    @Test
    public void testSaveShoppingOrder() {
        // Given: 필요한 엔티티와 관련된 데이터 설정
        Member member = memberRepository.findById(1L).orElseThrow(); // member id가 1인 회원 찾기
        Product product = productRepository.findById(4L).orElseThrow(); // product id가 4인 상품 찾기

        MyLocation myLocation = new MyLocation();
        myLocation.setAddress("123 Main St");
        myLocation.setMember(member);
        myLocation.setIsPrimary("Y");
        myLocation.setReceipientName("John Doe");
        myLocation.setReceipientTellNum("123-456-7890");
        myLocationRepository.save(myLocation); // MyLocation 저장

        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setTotalPrice(1000);
        shoppingOrder.setIsAllShipping("N");
        shoppingOrder.setMember(member);
        shoppingOrder.setMyLocation(myLocation);
        shoppingOrder.setReceipient_name("John Doe");
        shoppingOrder.setReceipient_telNum("123-456-7890");
        shoppingOrder.setBuyingDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        shoppingOrder.setMemo("First order");

        ShoppingOrder savedOrder = shoppingOrderRepository.save(shoppingOrder); // ShoppingOrder 저장

        // ShoppingOrderProduct 생성
        ShoppingOrderProduct orderProduct = new ShoppingOrderProduct();
        orderProduct.setShoppingOrder(savedOrder);
        orderProduct.setProduct(product);
        orderProduct.setCreatedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        orderProduct.setQuantity(1);
        orderProduct.setShippingStatus("대기");

        // ShoppingOrderProduct 저장
        //shoppingOrderProductServiceImpl.savePrdQuantityToOrder(orderProduct);
        shoppingOrderProductRepository.save(orderProduct);
        //shoppingOrderRepository.save(orderProduct);

        // When: 전체 ShoppingOrder 가져오기
        List<ShoppingOrder> orders = shoppingOrderRepository.findAll();

        // Then: 데이터 검증
        assertThat(orders).hasSize(1);
        assertThat(orders.get(0).getTotalPrice()).isEqualTo(1000);
        assertThat(orders.get(0).getOrderProductList()).hasSize(1);
        assertThat(orders.get(0).getOrderProductList().get(0).getProduct().getId()).isEqualTo(4);
    }
}
