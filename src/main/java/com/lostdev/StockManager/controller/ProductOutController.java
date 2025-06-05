package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.domain.stock.ProductOut;
import com.lostdev.StockManager.dtos.productOut.ProductOutBasicDTO;
import com.lostdev.StockManager.dtos.productOut.ProductOutPostDTO;
import com.lostdev.StockManager.service.domainService.ProductOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product_out")
@RequiredArgsConstructor
public class ProductOutController {

  private final ProductOutService productOutService;

//  @PostMapping
//  public ResponseEntity<ProductOutBasicDTO> save(@RequestBody ProductOutPostDTO productOutPostDTO){
//    return new ResponseEntity<ProductOutBasicDTO>(productOutService.save(productOutPostDTO), HttpStatus.CREATED);
//  }

  @GetMapping()
  public ResponseEntity<List<ProductOutBasicDTO>> listAll(){
    return ResponseEntity.ok(productOutService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductOut> findById(@PathVariable Long id){
    return ResponseEntity.ok(productOutService.findById(id));
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<List<ProductOutBasicDTO>> findAllWithProductId(@PathVariable Long productId){
    return ResponseEntity.ok(productOutService.findAllWithProductId(productId));
  }


}
