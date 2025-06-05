package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.dtos.Implement.ImplementBasicDTO;
import com.lostdev.StockManager.domain.Implement;
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

  public Implement save(Implement implement){
    return implementRepository.save(implement);
  }

  public List<ImplementBasicDTO> listAll(){
    return implementMapper.toBasicList(implementRepository.findAll());
  }

  public ImplementBasicDTO findById(Long id){
    return implementMapper.toBasic(implementRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nenhum resultado encontrado.")));
  }

}
