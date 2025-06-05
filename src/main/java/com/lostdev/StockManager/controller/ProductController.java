package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductNoReferenceDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.dtos.product.ProductPutDTO;
import com.lostdev.StockManager.service.domainService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping("/new")
  public ResponseEntity<ProductBasicDTO> save(@RequestBody ProductPostDTO productPostDTO){
    return new ResponseEntity<>(productService.save(productPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/new")
  public ResponseEntity<ProductPostDTO> blankPattern(){
    return ResponseEntity.ok(new ProductPostDTO());
  }

  @GetMapping()
  public ResponseEntity<List<ProductNoReferenceDTO>> listAll(){
    return ResponseEntity.ok(productService.listAll());
  }

  @GetMapping("/{id}/show")
  public ResponseEntity<Product> showProduct(@PathVariable Long id){
    return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/{id}/edit")
  public ResponseEntity<Product> replace(@PathVariable Long id, @RequestBody ProductPutDTO productPutDTO){
    return ResponseEntity.ok(productService.replace(id, productPutDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    productService.destroy(id);
    return ResponseEntity.noContent().build();
  }


}
 