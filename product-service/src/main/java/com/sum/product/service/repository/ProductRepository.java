package com.sum.product.service.repository;

import com.sum.product.service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
