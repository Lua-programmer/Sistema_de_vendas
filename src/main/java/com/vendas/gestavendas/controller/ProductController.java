package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.entity.Product;
import com.vendas.gestavendas.service.impl.ProductImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductImpl productService;

    @Operation(summary = "To List")
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Operation(summary = "List by Code")
    @GetMapping("product/{code}")
    public ResponseEntity<Optional<Product>> getProductByCode(@PathVariable UUID code) {
        Optional<Product> product = productService.getProductByCode(code);
        return product.isPresent() ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }
}
