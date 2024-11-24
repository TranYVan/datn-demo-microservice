package com.datn_microservices.order_service.services;

import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.dto.ProductDetailResponseDto;
import com.datn_microservices.order_service.dto.ProductDto;
import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.exception.NotEnoughResourceException;
import com.datn_microservices.order_service.mapper.OrderMapper;
import com.datn_microservices.order_service.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final HttpRequestService httpRequestService;
    private final ProductService productService;
    private final KafkaTemplate kafkaTemplate;

    public void createOrder(OrderDto  orderDto) {
        Map<Long, ProductDto> productDtoList = new HashMap<>();
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


        Order order = OrderMapper.toOrderEntity(orderDto);
        order.setOrder_date(LocalDate.now());
        Order saved_order = orderRepository.saveAndFlush(order);

        // Update the inventory
        orderDto.getItems().forEach(it -> {
            Long prod_id = it.getProd_id();
            ProductDto productDto = new ProductDto();
            productDto.setId(prod_id);
            productDto.setStock_quantity(productDtoList.get(prod_id).getStock_quantity() - it.getQuantity());
            System.out.println(productDto);
            httpRequestService.sendPutRequest(String.format("http://product_service:3000/api/products/%d", prod_id), productDto);
            // httpRequestService.sendPutRequest(String.format("http://localhost:3000/api/products/%d", prod_id), productDto);

            // kafkaTemplate.send("order", it);
        });
    }
}
