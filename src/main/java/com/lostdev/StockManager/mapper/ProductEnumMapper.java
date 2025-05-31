package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.enums.product.FormType;
import com.lostdev.StockManager.enums.product.HoseAdapterPoint;
import com.lostdev.StockManager.enums.product.ScrewNutsFlange;
import org.mapstruct.Mapper;

import java.util.Arrays;

@Mapper(componentModel = "spring")
public abstract class ProductEnumMapper {

  public FormType toFormType(String formType){
    return Arrays.stream(FormType.values())
        .filter(type -> type.toString().equalsIgnoreCase(formType))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("conversao mal sucedida "));
  }

  public HoseAdapterPoint toHoseAdapterPoint(String point){
    return Arrays.stream(HoseAdapterPoint.values())
        .filter(hoseAdapterPoint -> hoseAdapterPoint.getCode().equalsIgnoreCase(point))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("conversao mal sucedida "));
  }

  public ScrewNutsFlange toScrewNutsFlange(String flange){
    return Arrays.stream(ScrewNutsFlange.values())
        .filter(screwNutsFlange -> screwNutsFlange.toString().equalsIgnoreCase(flange))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("conversao mal sucedida "));
  }

}








