package com.sum.product.service.controller;

import com.sum.product.service.dto.ProductRequest;
import com.sum.product.service.dto.ProductResponse;
import com.sum.product.service.model.Product;
import com.sum.product.service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){

        productService.createProduct(productRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        log.info("Request received..");
       return  productService.getAllProducts();
    }

}
