package com.datn_microservices.order_service.services;

import com.datn_microservices.order_service.dto.ProductDetailResponseDto;
import com.datn_microservices.order_service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<ProductDetailResponseDto>  getProduct(Long id) {
        // String url = String.format("http://127.0.0.1:3000/api/products/%d", id);
        String url = String.format("http://product_service:3000/api/products/%d", id);
        ResponseEntity<ProductDetailResponseDto> productDetailResponseDto = restTemplate.getForEntity(url, ProductDetailResponseDto.class);
        return productDetailResponseDto;
    }
}
