package com.lostdev.StockManager.service;

import com.lostdev.StockManager.DTOs.Implement.ImplementBasicDTO;
import com.lostdev.StockManager.DTOs.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.stock.Implement;
import com.lostdev.StockManager.domain.stock.Recipe;
import com.lostdev.StockManager.mapper.ImplementMapper;
import com.lostdev.StockManager.repository.ImplementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImplementService {

  private final ImplementRepository implementRepository;
  private final ImplementMapper implementMapper;
  private final RecipeService recipeService;

  public Implement save(ImplementPostDTO implementPostDTO){
    Recipe recipe = recipeService.save(implementPostDTO.getRecipe());
    Implement implement = implementMapper.toImplement(implementPostDTO);
    implement.setRecipe(recipe);
    return implementRepository.save(implement);
  }

  public List<ImplementBasicDTO> listAll(){
    return implementRepository.findAll()
        .stream()
        .map(implementMapper::toBasic)
        .collect(Collectors.toList());
  }

  public ImplementBasicDTO findById(Long id){
    return implementMapper.toBasic(implementRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nenhum resultado encontrado.")));
  }

}
