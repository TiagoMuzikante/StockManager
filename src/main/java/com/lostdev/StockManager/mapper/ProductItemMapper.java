package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.dtos.utils.ProductItemBasicDTO;
import com.lostdev.StockManager.dtos.utils.ProductItemDTO;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.utils.ProductItem;
import com.lostdev.StockManager.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
@Log4j2
public abstract class ProductItemMapper {

  @Autowired
  private ProductService productService;

  @Mapping(source = "productId", target = "product", qualifiedByName = "idToProduct")
  public abstract ProductItem toProductItem(ProductItemDTO productItemDTO);

  public abstract ProductItemDTO toProductItemDTO(ProductItem productItem);

  @Mapping(source = "productId", target = "name", qualifiedByName = "idToName")
  public abstract ProductItemBasicDTO toBasic(ProductItem productItem);

  @Named("idToName")
  protected String idToName(Long id){
    log.info(productService.findById(id).toString());
    log.info("qualquer coisa");
    return idToProduct(id).getName();
  }

  @Named("idToProduct")
  protected Product idToProduct(Long id){
    return productService.findById(id);
  }

}
