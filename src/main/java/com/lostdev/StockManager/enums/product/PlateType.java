package com.lostdev.StockManager.enums.product;

public enum PlateType {
  VALOR_120("120"),
  VALOR_145("145"),
  FAIXA("FAIXA");

  private final String code;

  PlateType(String code) {
    this.code = code;
  }

  public String getCode(){
    return code;
  }
}
