package com.ukd.graphuserservice.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import com.ukd.graphuserservice.domain.User;
import com.ukd.graphuserservice.dto.UserDto;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);
}
