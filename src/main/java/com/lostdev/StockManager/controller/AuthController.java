package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.dtos.auth.LoginRequest;
import com.lostdev.StockManager.dtos.auth.TokenResponse;
import com.lostdev.StockManager.dtos.user.UserPutDTO;
import com.lostdev.StockManager.service.domainService.AuthService;
import com.lostdev.StockManager.service.domainService.UserService;
import com.lostdev.StockManager.util.auth.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {

  private final AuthService authService;
  private final JwtUtil jwtUtil;
  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){

    //userRepository.save(new User(null, "minerator", "admin@admin.com", passwordEncoder.encode("senha"), "ADMIN", "12 9 3456-1234"));

    return ResponseEntity.ok(authService.login(loginRequest));
  }

  @GetMapping("/current")
  public ResponseEntity<UserPutDTO> currentUser(@RequestHeader("Authorization") String token){
    return ResponseEntity.ok(userService.findByEmail(jwtUtil.extractUsername(token.substring(7))));
  }

}
