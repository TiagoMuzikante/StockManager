package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import com.lostdev.StockManager.repository.BuyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyOrderService {

  private final BuyOrderRepository buyOrderRepository;


  public BuyOrder save(BuyOrder buyOrder){
    buyOrder.getProduct().setPendingAmount(buyOrder.getProduct().getPendingAmount() + buyOrder.getAmount());

    return buyOrderRepository.save(buyOrder);
  }


}
