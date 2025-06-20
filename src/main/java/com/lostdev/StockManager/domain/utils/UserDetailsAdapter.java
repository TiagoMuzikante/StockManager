package com.lostdev.StockManager.domain.utils;

import com.lostdev.StockManager.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Log4j2
public class UserDetailsAdapter implements UserDetails {

  private User user;

  public boolean isAccountNonExpired() {
    return user.getIsAccountNonExpired();
  }

  public boolean isAccountNonLocked() {
    return user.getIsAccountNonLocked();
  }

  public boolean isCredentialsNonExpired() {
    return user.getIsCredentialsNonExpired();
  }

  public boolean isEnabled() {
    return user.getIsEnable();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    log.info(user.getAuthorities());
    return Arrays.stream(user.getAuthorities().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return "";
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }
}
