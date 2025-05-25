package com.lostdev.StockManager.service;

import com.lostdev.StockManager.DTOs.Implement.ImplementPostDTO;
import com.lostdev.StockManager.domain.stock.Implement;
import com.lostdev.StockManager.mapper.ImplementMapper;
import com.lostdev.StockManager.repository.ImplementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplementService {

  private final ImplementRepository implementRepository;
  private final ImplementMapper implementMapper;

  public Implement save(ImplementPostDTO implementPostDTO){
    return implementRepository.save(implementMapper.toImplement(implementPostDTO));
  }

  public List<Implement> listAll(){
    return implementRepository.findAll();
  }

  public Implement findById(Long id){
    return implementRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nenhum resultado encontrado."));
  }

}
