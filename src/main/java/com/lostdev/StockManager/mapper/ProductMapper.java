package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductNoReferenceDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.dtos.product.ProductPutDTO;
import com.lostdev.StockManager.service.SupplierService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = SupplierMapper.class)
public abstract class ProductMapper {

  @Autowired
  private SupplierService supplierService;

  @Mapping(target = "availableAmount", expression = "java(0)")
  @Mapping(target = "reservedAmount", expression = "java(0)")
  @Mapping(target = "pendingAmount", expression = "java(0)")
  @Mapping(target = "minimumAmount", expression = "java(0)")
  @Mapping(source = "supplierId", target = "supplier", qualifiedByName = "idToSupplier")
  public abstract Product toProduct(ProductPostDTO productPostDTO);

  public abstract Product toProduct(ProductPutDTO productPutDTO);

  public abstract ProductBasicDTO toProductBasic(Product product);

  public abstract ProductNoReferenceDTO toNoReferenceDTO(Product product);

  public List<ProductNoReferenceDTO> toNoReferenceList(List<Product> products){
    return products
        .stream()
        .map(this::toNoReferenceDTO)
        .collect(Collectors.toList());
  }

  public List<ProductBasicDTO> toProductBasicList(List<Product> products){
    return products.stream()
        .map(this::toProductBasic)
        .collect(Collectors.toList());
  }

  @Named("idToSupplier")
  protected Supplier idToSupplier(Long supplierId){
    if(supplierId == null) return null;
    return supplierService.findById(supplierId);
  }
}
