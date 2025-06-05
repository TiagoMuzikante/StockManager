package com.lostdev.StockManager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "app_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(unique = true)
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
