package com.vendas.gestavendas.repository;

import com.vendas.gestavendas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByName(String name);
}
