package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductEntry;
import com.lostdev.StockManager.DTOs.productEntry.ProductEntryBasicDTO;
import com.lostdev.StockManager.DTOs.productEntry.ProductEntryPostDTO;
import com.lostdev.StockManager.service.ProductService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public abstract class ProductEntryMapper {

  @Autowired
  protected ProductService productService;

  @Mapping(source="productId", target = "product", qualifiedByName = "mapIdToProduct")
  public abstract ProductEntry toProductEntry(ProductEntryPostDTO productEntryPostDTO);


  public abstract ProductEntryBasicDTO toBasic(ProductEntry productEntry);


  public List<ProductEntryBasicDTO> toBasicList(List<ProductEntry> productEntries){
    return productEntries
        .stream()
        .map(this::toBasic)
        .collect(Collectors.toList());
  }

  @Named("mapIdToProduct")
  protected Product mapIdToProduct(Long id){
    if(id == null) return null;
    return productService.findById(id);
  }


}
