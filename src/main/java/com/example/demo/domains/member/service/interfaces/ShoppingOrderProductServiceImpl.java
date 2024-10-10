package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.ShoppingOrder;
import com.example.demo.domains.member.entity.ShoppingOrderProduct;
import com.example.demo.domains.member.repository.ShoppingOrderProductRepository;
import com.example.demo.domains.member.service.impls.ShoppingOrderProductService;
import com.example.demo.domains.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingOrderProductServiceImpl implements ShoppingOrderProductService {
    @Autowired
    private ShoppingOrderProductRepository shoppingOrderProductRepository;

    @Override
    public Long savePrdQuantityToOrder(ShoppingOrderProduct shoppingOrderProduct) {
        ShoppingOrderProduct save = shoppingOrderProductRepository.save(shoppingOrderProduct);
        return save.getQuantity();
    }

    @Override
    public List<Product> findProductsByOrder(ShoppingOrder shoppingOrder) {
        List<Product> products = new ArrayList<>();
        List<ShoppingOrderProduct> byShoppingOrder = shoppingOrderProductRepository.findByShoppingOrder(shoppingOrder);
        for (ShoppingOrderProduct shoppingOrderProduct : byShoppingOrder) {
            products.add(shoppingOrderProduct.getProduct());
        }
        return products;
    }

    @Override
    public Long findPrdQuantityFromOrder(ShoppingOrderProduct shoppingOrderProduct) {
        long id = shoppingOrderProduct.getId();
        Optional<ShoppingOrderProduct> byId = shoppingOrderProductRepository.findById(id);
        return byId.get().getQuantity();
    }

    @Override
    public Boolean updatePrdQuantityFromOrder(Long shoppingOrderProductId, Long newQuantity) {
        try{
            ShoppingOrderProduct shoppingOrderProduct = shoppingOrderProductRepository.findById(shoppingOrderProductId)
                    .orElseThrow(() -> new RuntimeException("nsj: Shopping Order Product Not Found"));
            shoppingOrderProduct.setQuantity(newQuantity);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteProductFromOrder(ShoppingOrderProduct shoppingOrderProduct) {
        try{
            shoppingOrderProductRepository.delete(shoppingOrderProduct);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public long countByShippingStatus(String status) {
        return shoppingOrderProductRepository.countByShippingStatus(status);
    }
}
