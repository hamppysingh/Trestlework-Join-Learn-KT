package com.tretle.tech.ProductService.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.tretle.tech.ProductService.Repository.ProductRepository;
import com.tretle.tech.ProductService.dto.ProductRequest;
import com.tretle.tech.ProductService.dto.ProductResponse;
import com.tretle.tech.ProductService.pojo.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;


	public void createProduct(ProductRequest productRequest) {
    	 Product product=Product.builder()
    			 .name(productRequest.getName())
    			 .desc(productRequest.getDesc())
    			 .price(productRequest.getPrice())
    			 .build();
    	 productRepository.save(product);
    	 log.info("Product {}  is saved",product);
     }


	public List<ProductResponse> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> p=productRepository.findAll();
		return p.stream().map(product -> mapToProductResponse(product)).toList();
		
	}
	private ProductResponse mapToProductResponse(Product product)
	{
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
   			 .desc(product.getDesc())
   			 .price(product.getPrice())
   			 .build();
	}
}
