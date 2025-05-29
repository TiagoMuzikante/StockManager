package com.lostdev.StockManager.domain.listener;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.enums.buy.Reason;
import com.lostdev.StockManager.service.BuyOrderService;
import jakarta.persistence.PostPersist;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductOutListener {

  private final BuyOrderService buyOrderService;

  @PostPersist
  public void restockMinimal(ProductOut productOut){
    Product product = productOut.getProduct();
    if(product.getAvailableAmount() < product.getMinimumAmount()){
      int pendingAmount = product.getMinimumAmount() - product.getAvailableAmount();
      BuyOrder buyOrder = new BuyOrder(pendingAmount, Reason.RESERVA_TECNICA, product);
      buyOrderService.save(buyOrder);
    }
  }

}
  