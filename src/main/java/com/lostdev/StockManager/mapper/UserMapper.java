package com.lostdev.StockManager.mapper;

import com.lostdev.StockManager.domain.User;
import com.lostdev.StockManager.dtos.user.UserBasicDTO;
import com.lostdev.StockManager.dtos.user.UserPutDTO;
import com.lostdev.StockManager.dtos.user.UserPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

  public abstract User toUser(UserPostDTO userPostDTO);

  public abstract User toUser(UserPutDTO userPutDTO);

  public abstract UserBasicDTO toBasicDTO(User user);

  @Mapping(target = "password", expression = "java(null)")
  public abstract UserPutDTO toUserPutDTO(User user);

  public List<UserBasicDTO> toBasicList(List<User> users){
    return users.stream()
        .map(this::toBasicDTO)
        .collect(Collectors.toList());
  }
}
