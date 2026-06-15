package com.sparta.springminiproject.product.controller;

import com.sparta.springminiproject.product.dto.ProductRequestDto;
import com.sparta.springminiproject.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //상품 등록
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductRequestDto productRequestDto) {
        return  ResponseEntity.ok(productService.createProduct(productRequestDto));
    }

    //단건 조회
    @GetMapping("/{prodId}")
    public ResponseEntity<?> getProduct(@PathVariable Long prodId) {
        return ResponseEntity.ok(productService.getProduct(prodId));
    }

    //목록 조회
    @GetMapping("/list")
    public ResponseEntity<?> getProducts() {
        return  ResponseEntity.ok(productService.getAllProducts());
    }
    //상품 수정
    @PutMapping("/{prodId}")
    public ResponseEntity<?> update(@PathVariable Long prodId, @RequestBody ProductRequestDto productRequestDto) {
        return  ResponseEntity.ok(productService.updateProduct(prodId, productRequestDto));
    }

    //상품 삭제
    @DeleteMapping("/{prodId}")
    public ResponseEntity<?> delete(@PathVariable Long prodId) {
        productService.deleteProduct(prodId);
        return ResponseEntity.ok("삭제완료");
    }
}
