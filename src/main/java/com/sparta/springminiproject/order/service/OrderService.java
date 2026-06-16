package com.sparta.springminiproject.order.service;

import com.sparta.springminiproject.order.dto.OrderResponseDto;
import com.sparta.springminiproject.order.entity.Order;
import com.sparta.springminiproject.order.repository.OrderRepository;
import com.sparta.springminiproject.product.entity.Product;
import com.sparta.springminiproject.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    public final OrderRepository orderRepository;
    public final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public OrderResponseDto createOrder(Long prodId) {
        Product product = findProdById(prodId);
        Order order = orderRepository.save(new Order(product));
        product.decreaseStock();

        return OrderResponseDto.fromEntity(order);
    }

    public OrderResponseDto getOrder(Long orderId) {
        Order order = findOrderById(orderId);
        return OrderResponseDto.fromEntity(order);
    }

    public List<OrderResponseDto> getOrders() {
        return orderRepository.findAllByOrderByOrderIdAsc().stream()
                .map(OrderResponseDto::fromEntity).toList();
    }



    private Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->
                new IllegalArgumentException("해당 주문은 존재하지 않습니다."));
    }

    private Product findProdById(Long prodId) {
        return productRepository.findById(prodId).orElseThrow(()->
                new IllegalArgumentException("해당 상품은 존재하지 않습니다."));
    }
}
