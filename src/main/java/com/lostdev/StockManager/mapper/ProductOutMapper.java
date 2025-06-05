package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.dtos.productOut.ProductOutBasicDTO;
import com.lostdev.StockManager.dtos.productOut.ProductOutPostDTO;
import com.lostdev.StockManager.service.domainService.ProductService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public abstract class ProductOutMapper {

  @Autowired
  protected ProductService productService;

  @Mapping(source = "productId", target = "product", qualifiedByName = "mapIdToProduct")
  public abstract ProductOut toProductOut(ProductOutPostDTO productOutPostDTO);

  public abstract ProductOutBasicDTO toBasic(ProductOut productOut);

  public List<ProductOutBasicDTO> toBasicList(List<ProductOut> productOuts){
    return productOuts
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
