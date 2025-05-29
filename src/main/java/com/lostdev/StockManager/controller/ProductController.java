package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.domain.stock.Product;
import com.lostdev.StockManager.dtos.product.ProductBasicDTO;
import com.lostdev.StockManager.dtos.product.ProductNoReferenceDTO;
import com.lostdev.StockManager.dtos.product.ProductPostDTO;
import com.lostdev.StockManager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<ProductBasicDTO> save(@RequestBody ProductPostDTO productPostDTO){
    return new ResponseEntity<>(productService.save(productPostDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ProductBasicDTO>> listAllBasic(){
    return ResponseEntity.ok(productService.listAllBasic());
  }

  @GetMapping("/all")
  public ResponseEntity<List<ProductNoReferenceDTO>> listAll(){
    return ResponseEntity.ok(productService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> showProduct(@PathVariable Long id){
    return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
  }


}
 