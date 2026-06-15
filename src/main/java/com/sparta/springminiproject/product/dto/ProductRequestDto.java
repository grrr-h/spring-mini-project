package com.sparta.springminiproject.product.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String prodName;
    private Long prodPrice;
    private int stock;
}
