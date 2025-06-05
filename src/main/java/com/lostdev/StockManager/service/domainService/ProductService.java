package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductNoReferenceDTO;
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
  public List<ProductNoReferenceDTO> listAll(){
    return productMapper.toNoReferenceList(productRepository.findAll());
  }
  public Product save(Product product){return productRepository.save(product);}
  public ProductBasicDTO save(ProductPostDTO productPostDTO){
    Product save = save(productMapper.toProduct(productPostDTO));
    return productMapper.toProductBasic(save);
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
    destroy(id);
    return save(product);
  }
  public void destroy(Long id){
    productRepository.deleteById(id);
  }

//  public void reserveRecipe(List<ProductItem> productItems, Implement implement, Truck truck) {
//    for(ProductItem aux : productItems){
//      Product product = aux.getProduct();
//
//      if(aux.getProduct().getAvailableAmount() >= aux.getAmount()){
//        product.setAvailableAmount(product.getAvailableAmount() - aux.getAmount());
//        product.setReservedAmount(product.getReservedAmount() + aux.getAmount());
//        save(product);
//      }else {
//        Integer amount = aux.getAmount();
//        amount-= product.getAvailableAmount();
//        product.setAvailableAmount(0);
//        BuyOrder buyOrder = new BuyOrder(amount ,Reason.PEDIDO_PRODUCAO, implement, product, truck);
//        buyOrderService.save(buyOrder);
//      }
//    }
//  }
}








































