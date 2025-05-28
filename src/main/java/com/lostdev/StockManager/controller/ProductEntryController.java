package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.dtos.productEntry.ProductEntryBasicDTO;
import com.lostdev.StockManager.dtos.productEntry.ProductEntryPostDTO;
import com.lostdev.StockManager.service.ProductEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_entry")
@CrossOrigin
@RequiredArgsConstructor
public class ProductEntryController {

  private final ProductEntryService productEntryService;

  @PostMapping
  public ResponseEntity<ProductEntryBasicDTO> save(@RequestBody ProductEntryPostDTO productEntryPostDTO){
    return new ResponseEntity<>(productEntryService.save(productEntryPostDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ProductEntryBasicDTO>> listAll(){
    return new ResponseEntity<>(productEntryService.listAll(), HttpStatus.OK);
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<List<ProductEntryBasicDTO>> listAllWithProductId(@PathVariable Long productId){
    return new ResponseEntity<>(productEntryService.findAllWithProductId(productId), HttpStatus.OK);
  }

}
