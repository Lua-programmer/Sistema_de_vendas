package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.controller.dto.product.ProductRequestDTO;
import com.vendas.gestavendas.controller.dto.product.ProductResponseDTO;
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
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category/products")
public class ProductController {
    private final ProductImpl productService;

    @Operation(summary = "List All")
    @GetMapping
    public List<ProductResponseDTO> getProducts(@RequestParam UUID categoryCode) {
        return productService.getProducts(categoryCode).stream().map(ProductResponseDTO::convertForDTO).collect(Collectors.toList());
    }

    @Operation(summary = "List by Code")
    @GetMapping("product/{code}")
    public ResponseEntity<ProductResponseDTO> getProductByCode(@PathVariable UUID code, @RequestParam UUID categoryCode) {
        Optional<Product> product = productService.getByCodeCategory(code, categoryCode);
        return product.isPresent() ? ResponseEntity.ok(ProductResponseDTO.convertForDTO(product.get())) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveProduct(@Valid @RequestBody ProductRequestDTO productDto, @RequestParam UUID categoryCode) {
        Product productSaved = productService.saveProduct(productDto.convertForEntity(categoryCode), categoryCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponseDTO.convertForDTO(productSaved));
    }

    @Operation(summary = "Update product")
    @PutMapping("/updateProduct/{code}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID code, @RequestParam UUID categoryCode, @Valid @RequestBody ProductRequestDTO productDto) {
        Product productUpdated = productService.updateProduct(code, categoryCode, productDto.convertForEntity(categoryCode, code));
        return ResponseEntity.ok(ProductResponseDTO.convertForDTO(productUpdated));
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/deleteProduct/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable UUID code, @RequestParam UUID categoryCode) {
        productService.deleteProduct(code, categoryCode);
    }

}
