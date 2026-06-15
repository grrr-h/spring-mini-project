package com.sparta.springminiproject.product.service;

import com.sparta.springminiproject.product.dto.ProductRequestDto;
import com.sparta.springminiproject.product.dto.ProductResponseDto;
import com.sparta.springminiproject.product.entity.Product;
import com.sparta.springminiproject.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);
        Product saveProduct = productRepository.save(product);
        return ProductResponseDto.builder()
                .prodName(saveProduct.getProdName())
                .prodPrice(saveProduct.getProdPrice())
                .build();
    }

    public ProductResponseDto getProduct(Long prodId) {
        Product product = findProductById(prodId);
        return ProductResponseDto.builder()
                .prodName(product.getProdName())
                .prodPrice(product.getProdPrice())
                .build();
    }


    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(p -> ProductResponseDto.builder()
                        .prodName(p.getProdName())
                        .prodPrice(p.getProdPrice())
                        .prodId(p.getProdId())
                        .stock(p.getStock()).build()).toList();
    }

    @Transactional
    public ProductResponseDto updateProduct(Long prodId, ProductRequestDto productRequestDto) {
        Product product = findProductById(prodId);

        if(product != null) {
            Product updateProduct = product.updateProduct(productRequestDto);
            return ProductResponseDto.builder()
                    .prodName(updateProduct.getProdName())
                    .prodPrice(updateProduct.getProdPrice())
                    .stock(updateProduct.getStock())
                    .build();
        } else {
            throw new IllegalArgumentException("해당 상품은 존재하지 않습니다.");
        }
    }

    public void deleteProduct(Long prodId) {
        Product product = findProductById(prodId);
        if(product != null) {
            productRepository.delete(product);
        } else {
            throw new IllegalArgumentException("해당 상품은 존재하지 않습니다.");
        }
    }


    private Product findProductById(Long prodId) {
        return productRepository.findById(prodId).orElseThrow(()->
                new IllegalArgumentException("해당 상품은 존재하지 않습니다.")
        );
    }


}
