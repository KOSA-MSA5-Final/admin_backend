package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.ProductRepository;
import com.example.demo.domains.product.repository.querydsl.impls.ProductRepositoryImpl;
import com.example.demo.domains.product.service.interfaces.ProductService;
import com.example.demo.domains.profile_medical.entity.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImps implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(String name, String maker, String type, long price, Animal animal) {
        Product product = new Product();
        product.setName(name);
        product.setMaker(maker);
        product.setType(type);
        product.setPrice(price);
        product.setAnimal(animal);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
