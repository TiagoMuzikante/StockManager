package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.DTOs.product.ProductBasicDTO;
import com.lostdev.StockManager.DTOs.product.ProductPostDTO;
import com.lostdev.StockManager.DTOs.product.ProductPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

  @Mapping(target = "amount", expression = "java(0)")
  public abstract Product toProduct(ProductPostDTO productPostDTO);

  public abstract Product toProduct(ProductPutDTO productPutDTO);

  public abstract ProductBasicDTO toProductBasic(Product product);

  public List<ProductBasicDTO> toProductBasicList(List<Product> products){
    return products.stream()
        .map(this::toProductBasic)
        .collect(Collectors.toList());
  }

}
