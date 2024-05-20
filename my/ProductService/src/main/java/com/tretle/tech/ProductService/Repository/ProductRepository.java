package com.tretle.tech.ProductService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tretle.tech.ProductService.pojo.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

}
