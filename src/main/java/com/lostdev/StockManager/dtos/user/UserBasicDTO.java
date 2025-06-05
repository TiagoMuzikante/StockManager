package com.lostdev.StockManager.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBasicDTO {

  private Long id;
  private String name;
  private String email;
  private String phone_number;

}
