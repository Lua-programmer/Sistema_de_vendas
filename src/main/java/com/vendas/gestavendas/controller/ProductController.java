package com.vendas.gestavendas.controller;


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
@RequestMapping("/api/v1/category/products")
public class ProductController {
    private final ProductImpl productService;

    @Operation(summary = "To List")
    @GetMapping
    public List<Product> getProducts(@RequestParam UUID categoryCode) {
        return productService.getProducts(categoryCode);
    }

    @Operation(summary = "List by Code")
    @GetMapping("product/{code}")
    public ResponseEntity<Optional<Product>> getProductByCode(@PathVariable UUID code, @RequestParam UUID categoryCode) {
        Optional<Product> product = productService.getByCodeCategory(code, categoryCode);
        return product.isPresent() ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product, @RequestParam UUID categoryCode) {
        Product productSaved = productService.saveProduct(product, categoryCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @Operation(summary = "Update product")
    @PutMapping("/updateProduct/{code}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID code, @RequestParam UUID categoryCode, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(code, categoryCode, product));
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/deleteProduct/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable UUID code, @RequestParam UUID categoryCode) {
        productService.deleteProduct(code, categoryCode);
    }

}
