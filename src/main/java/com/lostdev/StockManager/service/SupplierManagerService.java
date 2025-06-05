package com.lostdev.StockManager.service;

import com.lostdev.StockManager.service.domainService.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Log4j2
public class SupplierManagerService {

  private final SupplierService supplierService;
  private final RestClient restClient;

  public void findCNPJ(String cnpj) {
    log.info(restClient.get().uri("https://publica.cnpj.ws/cnpj/40074949000150").retrieve().body(String.class));
  }

}
