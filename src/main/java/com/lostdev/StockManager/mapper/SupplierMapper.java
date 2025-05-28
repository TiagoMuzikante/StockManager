package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.dtos.supplier.SupplierBasicDTO;
import com.lostdev.StockManager.dtos.supplier.SupplierPostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SupplierMapper {

  public abstract Supplier toSupplier(SupplierPostDTO supplierPostDTO);

  public abstract SupplierBasicDTO toBasic(Supplier supplier);

}
