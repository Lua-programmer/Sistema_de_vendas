package com.vendas.gestavendas.repository;

import com.vendas.gestavendas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCode(Long code);
}
