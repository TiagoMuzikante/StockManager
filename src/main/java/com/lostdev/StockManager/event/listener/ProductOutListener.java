package com.lostdev.StockManager.event.listener;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.enums.buy.Reason;
import com.lostdev.StockManager.service.domainService.BuyOrderService;
import com.lostdev.StockManager.service.domainService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductOutListener {

  private final BuyOrderService buyOrderService;
  private final ProductService productService;

  @EventListener(condition = "#event.getProduct().getAvailableAmount() < #event.getProduct().getMinimumAmount()")
  public void restockMinimal(ProductOut event){
    Product product = event.getProduct();
    int pendingAmount = product.getMinimumAmount() - product.getAvailableAmount();
    BuyOrder buyOrder = new BuyOrder(pendingAmount, Reason.RESERVA_TECNICA, product);
    buyOrderService.save(buyOrder);
  }



}
