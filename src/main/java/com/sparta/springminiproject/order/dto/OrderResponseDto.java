package com.sparta.springminiproject.order.dto;

import com.sparta.springminiproject.order.entity.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderResponseDto {
    private Long orderId;
    private String prodName;


    @Builder
    public OrderResponseDto(Long orderId, String prodName) {
        this.orderId = orderId;
        this.prodName = prodName;
    }

    public static OrderResponseDto fromEntity(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .prodName(order.getProduct().getProdName())
                .build();
    }


}
