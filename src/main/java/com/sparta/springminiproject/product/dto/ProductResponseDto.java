package com.sparta.springminiproject.product.dto;

import com.sparta.springminiproject.product.entity.Product;
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

    public static ProductResponseDto fromEntity(Product product) {
        return ProductResponseDto.builder()
                .prodId(product.getProdId())
                .prodName(product.getProdName())
                .prodPrice(product.getProdPrice())
                .stock(product.getStock())
                .build();
    }
}
