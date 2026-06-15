package com.sparta.springminiproject.product.entity;


import com.sparta.springminiproject.product.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    @Column(nullable = false)
    private String prodName;
    private Long prodPrice;
    private int stock;


    public Product(ProductRequestDto productRequestDto) {
        this.prodName = productRequestDto.getProdName();
        this.prodPrice = productRequestDto.getProdPrice();
        this.stock = productRequestDto.getStock();
    }

    public Product updateProduct(ProductRequestDto productRequestDto) {
        this.prodName = productRequestDto.getProdName();
        this.prodPrice = productRequestDto.getProdPrice();
        this.stock = productRequestDto.getStock();
        return this;
    }

    public void decreaseStock() {
        if(this.stock <= 0) {
            throw new IllegalStateException("재고가 없습니다.");
        }
        this.stock -= 1;
    }

}
