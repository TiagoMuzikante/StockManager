package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.mapper.ProductOutMapper;
import com.lostdev.StockManager.repository.ProductOutRepository;
import com.lostdev.StockManager.dtos.productOut.ProductOutBasicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

  public ProductOut save(ProductOut productOut){
    return productOutRepository.save(productOut);
  }

}
