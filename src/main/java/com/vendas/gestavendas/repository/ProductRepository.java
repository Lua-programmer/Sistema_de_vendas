package com.vendas.gestavendas.repository;

import com.vendas.gestavendas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByCategoryCode(UUID categoryCode);

    @Query("Select prod"
            + " from Product prod "
            + " where prod.code = :code "
            + " and prod.category.code = :categoryCode")
    Optional<Product> findByCodeCategory(UUID code, UUID categoryCode);
    Optional<Product> findByCategoryCodeAndDescription(UUID codeCategory, String description);
}
