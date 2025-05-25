package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.mapper.ProductOutMapper;
import com.lostdev.StockManager.repository.ProductOutRepository;
import com.lostdev.StockManager.DTOs.productOut.ProductOutBasicDTO;
import com.lostdev.StockManager.DTOs.productOut.ProductOutPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOutService {

  private final ProductOutRepository productOutRepository;
  private final ProductService productService;
  private final ProductOutMapper productOutMapper;

  public List<ProductOutBasicDTO> findAll(){
    return productOutMapper.toBasicList(productOutRepository.findAll());
  }

  public List<ProductOutBasicDTO> findAllWithProductId(Long id){
    return productOutMapper.toBasicList(productOutRepository.findByProduct(productService.findById(id)));
  }

  public ProductOut findById(Long id){
    return productOutRepository.findById(id).orElseThrow(() -> new RuntimeException("Nenhum resultado encontrado."));
  }

  @Transactional
  public ProductOutBasicDTO save(ProductOutPostDTO productOutPostDTO){
    ProductOut productOut = productOutMapper.toProductOut(productOutPostDTO);
    productService.decrementAmount(productOut.getProduct(), productOut.getAmount());
    return productOutMapper.toBasic(productOutRepository.save(productOut));
  }

}
