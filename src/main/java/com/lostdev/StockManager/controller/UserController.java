package com.lostdev.StockManager.controller;

import com.lostdev.StockManager.dtos.user.UserBasicDTO;
import com.lostdev.StockManager.dtos.user.UserPutDTO;
import com.lostdev.StockManager.dtos.user.UserPostDTO;
import com.lostdev.StockManager.service.domainService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

  private final UserService userService;

  @PostMapping("/new")
  public ResponseEntity<UserPutDTO> save(@RequestBody UserPostDTO userPostDTO){
    return new ResponseEntity<UserPutDTO>(userService.save(userPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/new")
  public ResponseEntity<UserPostDTO> blankPattern(){
    return ResponseEntity.ok(new UserPostDTO());
  }

  @GetMapping()
  public ResponseEntity<List<UserBasicDTO>> listAll(){
    return ResponseEntity.ok(userService.listAll());
  }

  @GetMapping("/{id}/show")
  public ResponseEntity<UserPutDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @PutMapping("/{id}/edit")
  public ResponseEntity<UserPutDTO> replace(@PathVariable Long id, @RequestBody UserPostDTO userPostDTO){
    return ResponseEntity.ok(userService.replace(id, userPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    userService.destroy(id);
    return ResponseEntity.noContent().build();
  }

}
