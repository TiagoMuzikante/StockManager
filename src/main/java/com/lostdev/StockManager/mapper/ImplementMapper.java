package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.dtos.Implement.ImplementBasicDTO;
import com.lostdev.StockManager.dtos.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.Implement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = RecipeMapper.class)
public abstract class ImplementMapper {

  @Mapping(target = "recipe", ignore = true)
  public abstract Implement toImplement(ImplementPostDTO implementPostDTO);

  public abstract ImplementBasicDTO toBasic(Implement implement);

  public List<ImplementBasicDTO> toBasicList(List<Implement> implementList){
    return implementList
        .stream()
        .map(this::toBasic)
        .collect(Collectors.toList());
  }

}
