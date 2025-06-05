package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.stock.ProductEntry;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryBasicDTO;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryPostDTO;
import com.lostdev.StockManager.dtos.productOut.ProductOutBasicDTO;
import com.lostdev.StockManager.dtos.productOut.ProductOutPostDTO;
import com.lostdev.StockManager.mapper.ProductEntryMapper;
import com.lostdev.StockManager.mapper.ProductOutMapper;
import com.lostdev.StockManager.service.domainService.ProductEntryService;
import com.lostdev.StockManager.service.domainService.ProductOutService;
import com.lostdev.StockManager.service.domainService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductManagerService {

  private final ProductService productService;
  private final ProductEntryService productEntryService;
  private final ProductOutService productOutService;
  private final ProductEntryMapper productEntryMapper;
  private final ProductOutMapper productOutMapper;

  //private final ApplicationEventPublisher publisher;

  //revisar
  public ProductOutBasicDTO save(ProductOutPostDTO productOutPostDTO){
    //productService.decrementsAvailableAmount(productOut.getProduct(), productOut.getAmount());
    //publisher.publishEvent(new ProductOutCreatedEvent(save));
    return productOutMapper.toBasic(productOutService.save(productOutMapper.toProductOut(productOutPostDTO)));
  }

  // revisar
  public ProductEntryBasicDTO save(ProductEntryPostDTO productEntryPostDTO){
    ProductEntry productEntry = productEntryMapper.toProductEntry(productEntryPostDTO);
    //productService.incrementAvailableAmount(productEntry.getProduct(),productEntry.getAmount());
    return productEntryMapper.toBasic(productEntryService.save(productEntry));
  }

}
