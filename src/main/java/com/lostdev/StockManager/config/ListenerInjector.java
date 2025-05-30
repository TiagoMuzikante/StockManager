package com.lostdev.StockManager.config;

import com.lostdev.StockManager.domain.listener.ProductOutListener;
import com.lostdev.StockManager.service.BuyOrderService;
import org.springframework.stereotype.Component;

@Component
public class ListenerInjector {

  public ListenerInjector(BuyOrderService buyOrderService) {
    ProductOutListener.buyOrderService = buyOrderService;
  }
}