package com.lostdev.StockManager.controller;


import com.lostdev.StockManager.DTOs.recipe.RecipePostDTO;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/recipe")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RecipeController {

  private final RecipeService recipeService;

  @PostMapping
  public ResponseEntity<Recipe> save(RecipePostDTO recipePostDTO){
    return new ResponseEntity<Recipe>(recipeService.save(recipePostDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Recipe>> listAll(){
    return ResponseEntity.ok(recipeService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Recipe> findById(@PathVariable Long id){
    return ResponseEntity.ok(recipeService.findById(id));
  }


}
