package com.datn_microservices.order_service.services;

import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.dto.ProductDetailResponseDto;
import com.datn_microservices.order_service.dto.ProductDto;
import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.entities.Order_Detail;
import com.datn_microservices.order_service.exception.NotEnoughResourceException;
import com.datn_microservices.order_service.mapper.OrderMapper;
import com.datn_microservices.order_service.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final HttpRequestService httpRequestService;
    private final ProductService productService;

    public void createOrder(OrderDto orderDto) {
        Map<Long, ProductDto> productDtoList = new HashMap<Long, ProductDto>();
        // Validate the ordered quantity
        orderDto.getItems().forEach(it -> {
            Long prod_id = it.getProd_id();
            ResponseEntity<ProductDetailResponseDto> productDetailResponseDtoResponseEntity = productService.getProduct(prod_id);
            ProductDetailResponseDto productDetailResponseDto = productDetailResponseDtoResponseEntity.getBody();
            ProductDto productDto = productDetailResponseDto.getData();

            productDtoList.put(prod_id, productDto);
            if (productDto.getStock_quantity() <it.getQuantity()) {
                throw new NotEnoughResourceException("There are not enough products in stock for selling.");
            }
        });

        // Handle the order

        Order order = OrderMapper.map_to_entity(orderDto, new Order());
        order.setOrder_date(LocalDate.now());
        System.out.println(order);
        Order saved_order = orderRepository.saveAndFlush(order);

        // Update the inventory
        orderDto.getItems().forEach(it -> {
            Long prod_id = it.getProd_id();
            ProductDto productDto = new ProductDto();
            productDto.setId(prod_id);
            productDto.setStock_quantity(productDtoList.get(prod_id).getStock_quantity() - it.getQuantity());
            httpRequestService.sendPutRequest(String.format("http://127.0.0.1:3000/api/products/%d", prod_id), productDto);
        });
    }
}
