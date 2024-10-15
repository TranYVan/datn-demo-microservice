package com.datn_microservices.order_service.controllers;

import com.datn_microservices.order_service.services.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class OrderController {

    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> create_order(@RequestBody )
}
