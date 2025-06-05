package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductNoReferenceDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.dtos.product.ProductPutDTO;
import com.lostdev.StockManager.service.domainService.SupplierService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {SupplierMapper.class, ProductEnumMapper.class})
public abstract class ProductMapper {

  @Autowired
  private SupplierService supplierService;

  private Integer priceInCents;
  private Double priceVariationPercent;

  @Mapping(target = "availableAmount", expression = "java(0)")
  @Mapping(target = "reservedAmount", expression = "java(0)")
  @Mapping(target = "pendingAmount", expression = "java(0)")
  @Mapping(source = "no_address", target = "noAddress")
  @Mapping(source = "form_type", target = "formType")
  @Mapping(source = "width_cm", target = "widthCm")
  @Mapping(source = "length_cm", target = "lengthCm")
  @Mapping(source = "inner_diameter", target = "innerDiameter")
  @Mapping(source = "outer_diameter", target = "outerDiameter")
  @Mapping(source = "jic_mm", target = "jicMm")
  @Mapping(source = "opened_depth", target = "openedDepth")
  @Mapping(source = "closed_depth", target = "closedDepth")
  @Mapping(source = "price_in_cents", target = "priceInCents")
  @Mapping(source = "price_variation_percent", target = "priceVariationPercent")
  @Mapping(source = "supplier", target = "supplier", qualifiedByName = "stringToSupplier")
  public abstract Product toProduct(ProductPostDTO productPostDTO);

  @Mapping(target = "availableAmount", expression = "java(0)")
  @Mapping(target = "reservedAmount", expression = "java(0)")
  @Mapping(target = "pendingAmount", expression = "java(0)")
  @Mapping(source = "no_address", target = "noAddress")
  @Mapping(source = "form_type", target = "formType")
  @Mapping(source = "width_cm", target = "widthCm")
  @Mapping(source = "length_cm", target = "lengthCm")
  @Mapping(source = "inner_diameter", target = "innerDiameter")
  @Mapping(source = "outer_diameter", target = "outerDiameter")
  @Mapping(source = "jic_mm", target = "jicMm")
  @Mapping(source = "opened_depth", target = "openedDepth")
  @Mapping(source = "closed_depth", target = "closedDepth")
  @Mapping(source = "price_in_cents", target = "priceInCents")
  @Mapping(source = "price_variation_percent", target = "priceVariationPercent")
  @Mapping(source = "supplier", target = "supplier", qualifiedByName = "stringToSupplier")
  public abstract Product toProduct(ProductPutDTO productPutDTO);

  @Mapping(source = "noAddress", target = "no_address")
  @Mapping(source = "formType", target = "form_type")
  @Mapping(source = "widthCm", target = "width_cm")
  @Mapping(source = "lengthCm", target = "length_cm")
  @Mapping(source = "innerDiameter", target = "inner_diameter")
  @Mapping(source = "outerDiameter", target = "outer_diameter")
  @Mapping(source = "jicMm", target = "jic_mm")
  @Mapping(source = "openedDepth", target = "opened_depth")
  @Mapping(source = "closedDepth", target = "closed_depth")
  @Mapping(source = "priceInCents", target = "price_in_cents")
  @Mapping(source = "priceVariationPercent", target = "price_variation_percent")
  @Mapping(target = "supplier", expression = "java(product.getSupplier().getName())")
  public abstract ProductPutDTO toProductPutDTO(Product product);

  @Mapping(source = "priceInCents", target = "price_in_cents")
  public abstract ProductBasicDTO toProductBasic(Product product);

  @Mapping(source = "noAddress", target = "no_address")
  @Mapping(source = "formType", target = "form_type")
  @Mapping(source = "widthCm", target = "width_cm")
  @Mapping(source = "lengthCm", target = "length_cm")
  @Mapping(source = "innerDiameter", target = "inner_diameter")
  @Mapping(source = "outerDiameter", target = "outer_diameter")
  @Mapping(source = "jicMm", target = "jic_mm")
  @Mapping(source = "openedDepth", target = "opened_depth")
  @Mapping(source = "closedDepth", target = "closed_depth")
  @Mapping(source = "priceInCents", target = "price_in_cents")
  @Mapping(source = "priceVariationPercent", target = "price_variation_percent")
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

  @Named("stringToSupplier")
  public Supplier idToSupplier(String supplier){
    if(supplier == null) return null;
    return supplierService.findById(Long.parseLong(supplier));
  }
}
