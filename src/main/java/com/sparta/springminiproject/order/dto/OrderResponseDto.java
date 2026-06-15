package com.sparta.springminiproject.order.dto;

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
}
