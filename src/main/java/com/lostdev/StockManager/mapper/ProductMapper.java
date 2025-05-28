package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.dtos.product.ProductPutDTO;
import com.lostdev.StockManager.service.SupplierService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

  @Autowired
  private SupplierService supplierService;

  @Mapping(target = "availableAmount", expression = "java(0)")
  @Mapping(target = "reservedAmount", expression = "java(0)")
  @Mapping(target = "pendingAmount", expression = "java(0)")
  @Mapping(source = "supplierId", target = "supplier", qualifiedByName = "idToSupplier")
  public abstract Product toProduct(ProductPostDTO productPostDTO);

  public abstract Product toProduct(ProductPutDTO productPutDTO);

  public abstract ProductBasicDTO toProductBasic(Product product);

  public List<ProductBasicDTO> toProductBasicList(List<Product> products){
    return products.stream()
        .map(this::toProductBasic)
        .collect(Collectors.toList());
  }

  @Named("idToSupplier")
  protected Supplier idToSupplier(Long supplierId){
    return supplierService.findById(supplierId);
  }

}
