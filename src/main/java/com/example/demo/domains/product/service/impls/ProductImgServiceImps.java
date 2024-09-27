package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.ProductImg;
import com.example.demo.domains.product.repository.ProductImgRepository;
import com.example.demo.domains.product.service.interfaces.ProductImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 이미지 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class ProductImgServiceImps implements ProductImgService {

    private final ProductImgRepository productImgRepository;

    @Override
    public List<ProductImg> getAllProductImgs() {
        return productImgRepository.findAll();
    }

    @Override
    public ProductImg saveProductImg(String imageUrl, Product product) {
        ProductImg productImg = new ProductImg();
        productImg.setImageUrl(imageUrl);
        productImg.setProduct(product);
        return productImgRepository.save(productImg);
    }

    @Override
    public void deleteProductImg(long id) {
        productImgRepository.deleteById(id);
    }
}
