package com.lostdev.StockManager.service.domainService;

import com.lostdev.StockManager.domain.User;
import com.lostdev.StockManager.dtos.user.UserBasicDTO;
import com.lostdev.StockManager.dtos.user.UserPutDTO;
import com.lostdev.StockManager.dtos.user.UserPostDTO;
import com.lostdev.StockManager.mapper.UserMapper;
import com.lostdev.StockManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public User save(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    if(user.getAuthorities() == null) user.setAuthorities("NORMAL");
    return userRepository.save(user);
  }
  public UserPutDTO save(UserPostDTO userPostDTO){
    return userMapper.toUserPutDTO(save(userMapper.toUser(userPostDTO)));
  }

  public List<UserBasicDTO> listAll(){
    return userMapper.toBasicList(userRepository.findAll());
  }

  public UserPutDTO findById(Long id){
    return userMapper.toUserPutDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("usuario nao encontrado")));
  }

  public UserPutDTO findByEmail(String email){
    return userMapper.toUserPutDTO(userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("usuario nao encontrado")));
  }

  public UserPutDTO replace(Long id, UserPostDTO userPostDTO){
    User user = userMapper.toUser(userPostDTO);
    user.setId(id);
    return userMapper.toUserPutDTO(save(user));
  }

  public void destroy(Long id){
    userRepository.deleteById(id);
  }

}
