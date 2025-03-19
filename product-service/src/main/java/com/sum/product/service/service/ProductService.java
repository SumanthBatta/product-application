package com.sum.product.service.service;


import com.sum.product.service.ProductServiceApplication;
import com.sum.product.service.dto.ProductRequest;
import com.sum.product.service.dto.ProductResponse;
import com.sum.product.service.model.Product;
import com.sum.product.service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        log.info("Retrieved products: {}", products);
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }

}
