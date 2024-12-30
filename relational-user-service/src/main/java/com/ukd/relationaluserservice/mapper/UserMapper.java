package com.ukd.relationaluserservice.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import com.ukd.relationaluserservice.domain.User;
import com.ukd.relationaluserservice.dto.UserDto;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);
}
