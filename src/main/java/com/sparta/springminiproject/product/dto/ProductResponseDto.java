package com.sparta.springminiproject.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long prodId;
    private String prodName;
    private Long prodPrice;
    private int stock;


    @Builder
    public ProductResponseDto(Long prodId, String prodName, Long prodPrice, int stock) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.stock = stock;
    }


}
