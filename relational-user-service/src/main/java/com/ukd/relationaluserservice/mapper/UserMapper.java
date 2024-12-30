package com.ukd.relationaluserservice.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ukd.relationaluserservice.domain.User;
import com.ukd.relationaluserservice.dto.CreateUserDto;
import com.ukd.relationaluserservice.dto.UserDto;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    @Mapping(target = "role", expression = "java(com.ukd.relationaluserservice.domain.Role.valueOf(user.getRole().toUpperCase()))")
    User toEntityDto(CreateUserDto user);

}
