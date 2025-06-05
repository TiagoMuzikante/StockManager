package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.stock.BuyOrder;
import com.lostdev.StockManager.repository.BuyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyOrderService {

  private final BuyOrderRepository buyOrderRepository;


  public BuyOrder save(BuyOrder buyOrder){
    return buyOrderRepository.save(buyOrder);
  }

  public BuyOrder findById(Long id){
    return buyOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("nenhum resultado encontado"));
  }

}
