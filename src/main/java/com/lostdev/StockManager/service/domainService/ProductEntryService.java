package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.stock.ProductEntry;
import com.lostdev.StockManager.mapper.ProductEntryMapper;
import com.lostdev.StockManager.repository.ProductEntryRepository;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryBasicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductEntryService {

  private final ProductEntryRepository productEntryRepository;
  private final ProductService productService;
  private final ProductEntryMapper productEntryMapper;

  public ProductEntry save(ProductEntry productEntry){
    return productEntryRepository.save(productEntry);
  }

  public ProductEntryBasicDTO findById(Long id){
    return productEntryMapper.toBasic(productEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("Entrada de produto não encontrada")));
  }

  public List<ProductEntryBasicDTO> listAll(){
    return productEntryMapper.toBasicList(productEntryRepository.findAll());
  }

  public List<ProductEntryBasicDTO> findAllWithProductId(Long id){
    return productEntryMapper.toBasicList(productEntryRepository.findByProduct(productService.findById(id)));
  }

}
