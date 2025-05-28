package com.lostdev.StockManager.service;

import com.lostdev.StockManager.domain.Supplier;
import com.lostdev.StockManager.dtos.supplier.SupplierBasicDTO;
import com.lostdev.StockManager.dtos.supplier.SupplierPostDTO;
import com.lostdev.StockManager.mapper.SupplierMapper;
import com.lostdev.StockManager.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

  private final SupplierMapper supplierMapper;
  private final SupplierRepository supplierRepository;


  public SupplierBasicDTO save(SupplierPostDTO supplierPostDTO){
    return supplierMapper.toBasic(supplierRepository.save(supplierMapper.toSupplier(supplierPostDTO)));
  }

  public List<SupplierBasicDTO> listAll(){
    return supplierRepository.findAll()
        .stream()
        .map(supplierMapper::toBasic)
        .collect(Collectors.toList());
  }

  public Supplier findById(Long id){
    return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("nenhum resultado encontrado"));
  }

  public void destroy(Long id){
    supplierRepository.delete(findById(id));

  }

}
