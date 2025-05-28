package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.stock.ProductEntry;
import com.lostdev.StockManager.mapper.ProductEntryMapper;
import com.lostdev.StockManager.repository.ProductEntryRepository;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryBasicDTO;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductEntryService {

  private final ProductEntryRepository productEntryRepository;
  private final ProductService productService;
  private final ProductEntryMapper productEntryMapper;

  @Transactional
  public ProductEntryBasicDTO save(ProductEntryPostDTO productEntryPostDTO){
    ProductEntry productEntry = productEntryMapper.toProductEntry(productEntryPostDTO);
    productService.incrementAmount(productEntry.getProduct(),productEntry.getAmount());
    return productEntryMapper.toBasic(productEntryRepository.save(productEntry));
  }

  public ProductEntry findById(Long id){
    return productEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entrada de produto não encontrada"));
  }

  public List<ProductEntryBasicDTO> listAll(){
    return productEntryMapper.toBasicList(productEntryRepository.findAll());
  }

  public List<ProductEntryBasicDTO> findAllWithProductId(Long id){
    return productEntryMapper.toBasicList(productEntryRepository.findByProduct(productService.findById(id)));
  }

}
