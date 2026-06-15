package com.sparta.springminiproject.order.controller;

import com.sparta.springminiproject.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //상품 주문
    @PostMapping("/{prodId}")
    public ResponseEntity<?> create(@PathVariable Long prodId) {
        return ResponseEntity.ok(orderService.createOrder(prodId));
    }
    //주문 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
    //주문 목록
    @GetMapping("/list")
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(orderService.getOrders());
    }
}
