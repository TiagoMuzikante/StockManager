package com.lostdev.StockManager.controller;


import com.lostdev.StockManager.domain.Recipe;
import com.lostdev.StockManager.service.domainService.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recipe")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RecipeController {

  private final RecipeService recipeService;

  @GetMapping
  public ResponseEntity<List<Recipe>> listAll(){
    return ResponseEntity.ok(recipeService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Recipe> findById(@PathVariable Long id){
    return ResponseEntity.ok(recipeService.findById(id));
  }


}
