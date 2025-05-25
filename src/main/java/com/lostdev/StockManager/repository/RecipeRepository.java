package com.lostdev.StockManager.repository;

import com.lostdev.StockManager.domain.stock.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
