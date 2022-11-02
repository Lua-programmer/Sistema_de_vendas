package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.entity.Product;
import com.vendas.gestavendas.service.impl.ProductImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        Product productSaved = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }
}
