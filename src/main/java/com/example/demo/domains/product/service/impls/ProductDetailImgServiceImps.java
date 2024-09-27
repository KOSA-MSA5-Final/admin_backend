package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.ProductDetailImg;
import com.example.demo.domains.product.repository.ProductDetailImgRepository;
import com.example.demo.domains.product.service.interfaces.ProductDetailImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 상세 이미지 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class ProductDetailImgServiceImps implements ProductDetailImgService {
    private final ProductDetailImgRepository productDetailImgRepository;

    @Override
    public List<ProductDetailImg> getAllProductDetailImgs() {
        return productDetailImgRepository.findAll();
    }

    @Override
    public ProductDetailImg saveProductDetailImg(String imageUrl, Product product) {
        ProductDetailImg productDetailImg = new ProductDetailImg();
        productDetailImg.setImageUrl(imageUrl);
        productDetailImg.setProduct(product);
        return productDetailImgRepository.save(productDetailImg);
    }

    @Override
    public void deleteProductDetailImg(long id) {
        productDetailImgRepository.deleteById(id);
    }
}
