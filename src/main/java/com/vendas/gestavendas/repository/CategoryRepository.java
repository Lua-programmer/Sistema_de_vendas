package com.vendas.gestavendas.repository;

import com.vendas.gestavendas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
