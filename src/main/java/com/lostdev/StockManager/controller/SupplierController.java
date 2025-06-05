package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.dtos.supplier.SupplierBasicDTO;
import com.lostdev.StockManager.dtos.supplier.SupplierPostDTO;
import com.lostdev.StockManager.service.domainService.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierController {


  private final SupplierService supplierService;

  @PostMapping
  public ResponseEntity<SupplierBasicDTO> save(@RequestBody SupplierPostDTO supplierPostDTO){
    return new ResponseEntity<SupplierBasicDTO>(supplierService.save(supplierPostDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<SupplierBasicDTO>> listAll(){
    return ResponseEntity.ok(supplierService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Supplier> findById(@PathVariable Long id){
    return ResponseEntity.ok(supplierService.findById(id));
  }

//  @GetMapping("/cnpj/{cnpj}")
//  public ResponseEntity<?> findCNPJ(@PathVariable String cnpj){
//    supplierService.findCNPJ(cnpj);
//    return ResponseEntity.noContent().build();
//  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    supplierService.destroy(id);
    return ResponseEntity.noContent().build();
  }

}
