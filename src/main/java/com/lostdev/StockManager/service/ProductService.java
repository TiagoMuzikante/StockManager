package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.mapper.ProductMapper;
import com.lostdev.StockManager.repository.ProductRepository;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.dtos.product.ProductPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public List<ProductBasicDTO> listAllBasic(){
    return productMapper.toProductBasicList(productRepository.findAll());
  }

  public List<ProductBasicDTO> listAll(){
    return productMapper.toProductBasicList(productRepository.findAll());
  }

  public Product save(Product product){return productRepository.save(product);}
  public ProductBasicDTO save(ProductPostDTO productPostDTO){
    return productMapper.toProductBasic(save(productMapper.toProduct(productPostDTO)));
  }

  public Product findById(Long id) {
      return productRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("Product not found"));
  }

  public Product replace(Long id, ProductPutDTO productPutDTO){
    return replace(id, productMapper.toProduct(productPutDTO));
  }

  public Product replace(Long id, Product product){
    product.setId(id);
    delete(id);
    return save(product);
  }

  public void decrementAmount(Product product, int amount){
    product.setAvailableAmount(product.getAvailableAmount() - amount);
    productRepository.save(product);
  }

  public void incrementAmount(Product product, int amount){
    product.setAvailableAmount(product.getAvailableAmount() + amount);
  }

  public void delete(Long id){
    productRepository.delete(findById(id));
  }

}








































