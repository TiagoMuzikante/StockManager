package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.User;
import com.lostdev.StockManager.dtos.auth.LoginRequest;
import com.lostdev.StockManager.dtos.auth.TokenResponse;
import com.lostdev.StockManager.mapper.UserMapper;
import com.lostdev.StockManager.repository.UserRepository;
import com.lostdev.StockManager.util.auth.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;
  private final JwtUtil jwtUtil;
  @Value("${jwt.secretFront}")
  private String frontToken;

  public TokenResponse login(LoginRequest request){
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

    if(request.getFrontSecret() == null ||
        !passwordEncoder.matches(request.getPassword(), user.getPassword()) ||
        !passwordEncoder.matches(frontToken, request.getFrontSecret())){
      throw new RuntimeException("Credenciais invalidas");
    }

    String token = jwtUtil.generateToken(user.getEmail());
    return new TokenResponse(token, userMapper.toUserPutDTO(user));
  }
}
