package com.lostdev.StockManager.enums.product;

public enum HoseAdapterPoint {
  RETA("RETA"),
  VALOR_90("90"),
  VALOR_90_LONGO("90_LONGO");

  private final String code;

  HoseAdapterPoint(String code){
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
