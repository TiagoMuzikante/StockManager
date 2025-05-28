package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.DTOs.Implement.ImplementBasicDTO;
import com.lostdev.StockManager.DTOs.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.stock.Implement;
import com.lostdev.StockManager.service.ImplementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/implement")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ImplementController {

  private final ImplementService implementService;

  @PostMapping
  public ResponseEntity<Implement> save(@RequestBody ImplementPostDTO implementPostDTO){
    return new ResponseEntity<>(implementService.save(implementPostDTO), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ImplementBasicDTO>> listAll(){
    return ResponseEntity.ok(implementService.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ImplementBasicDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(implementService.findById(id));
  }

}
