package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.DTOs.utils.ProductItemDTO;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.utils.ProductItem;
import com.lostdev.StockManager.service.ProductService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductItemMapper {

  @Autowired
  private ProductService productService;

  @Mapping(source = "productId", target = "product", qualifiedByName = "idToProduct")
  protected abstract ProductItem toProductItem(ProductItemDTO productItemDTO);

  protected abstract ProductItemDTO toProductItemDTO(ProductItem productItem);

  @Named("idToProduct")
  protected Product idToProduct(Long id){
    return productService.findById(id);
  }

}
