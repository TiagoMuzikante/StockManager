package com.lostdev.StockManager.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {

  private String name;
  private String email;
  private String password;
  private String phone_number;

  // auth
  private Boolean isEnable;
  private Boolean isAccountNonLocked;
  private Boolean isAccountNonExpired;
  private Boolean isCredentialsNonExpired;
  private String authorities;

}
