package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.DTOs.Implement.ImplementBasicDTO;
import com.lostdev.StockManager.DTOs.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.stock.Implement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RecipeMapper.class)
public abstract class ImplementMapper {

  @Mapping(target = "recipe", ignore = true)
  public abstract Implement toImplement(ImplementPostDTO implementPostDTO);

  public abstract ImplementBasicDTO toBasic(Implement implement);
  
}
