package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.dto.ProductDTO;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.ProductRepository;
import com.example.demo.domains.product.repository.querydsl.impls.ProductRepositoryImpl;
import com.example.demo.domains.product.service.interfaces.ProductService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.repository.AnimalRepository;
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
    private final AnimalRepository animalRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findByType(String type) {
        return productRepository.findAllByType(type);
    }

    public void update(Long id, ProductDTO productDto) {
        // 기존 상품 가져오기
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

        // 업데이트할 필드 설정
        product.setName(productDto.getProductName());
        product.setMaker(productDto.getProductMaker());
        product.setType(productDto.getProductType());
        product.setSubtype(productDto.getProductSubtype());
        product.setPrice(productDto.getProductPrice());
        product.setAnimal(animalRepository.findAnimalByName(productDto.getAnimalName())); // 동물 업데이트
        product.setOrigin(productDto.getProductOrigin());
        product.setAll_rawmaterial(productDto.getProductAllRawmaterial());
        product.setIngredient(productDto.getProductIngredient());
        product.setCalories(productDto.getProductCalories());
        product.setWeight(productDto.getProductWeight());
        product.setAge_group(productDto.getProductAge());
        product.setFunction(productDto.getProductFunction());

        // 상품 업데이트
        productRepository.save(product);
    }
}
