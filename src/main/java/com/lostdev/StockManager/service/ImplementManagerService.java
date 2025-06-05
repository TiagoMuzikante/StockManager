package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.Implement;
import com.lostdev.StockManager.domain.Recipe;
import com.lostdev.StockManager.dtos.Implement.ImplementPostDTO;
import com.lostdev.StockManager.mapper.ImplementMapper;
import com.lostdev.StockManager.service.domainService.ImplementService;
import com.lostdev.StockManager.service.domainService.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplementManagerService {

  private final ImplementService implementService;
  private final RecipeService recipeService;
  private final ImplementMapper implementMapper;

  public Implement save(ImplementPostDTO implementPostDTO){
    Recipe recipe = recipeService.save(implementPostDTO.getRecipe());
    Implement implement = implementMapper.toImplement(implementPostDTO);
    implement.setRecipe(recipe);
    return implementService.save(implement);
  }

}
