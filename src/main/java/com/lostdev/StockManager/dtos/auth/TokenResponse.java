package com.lostdev.StockManager.dtos.auth;

import com.lostdev.StockManager.dtos.user.UserPutDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenResponse {

  private String token;
  private UserPutDTO user;

}
