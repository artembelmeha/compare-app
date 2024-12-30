package com.ukd.relationaluserservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.relationaluserservice.domain.User;
import com.ukd.relationaluserservice.dto.CreateUserDto;
import com.ukd.relationaluserservice.dto.UserDto;
import com.ukd.relationaluserservice.mapper.UserMapper;
import com.ukd.relationaluserservice.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String getAllUsers() {
        return String.valueOf(userRepository.findAll().size());
    }

    public List<UserDto> getUsers(String userName) {
        var allByFirstName = userRepository.getAllByFirstName(userName);
        return userMapper.toDto(allByFirstName);
    }

    public List<UserDto> getUsersByCourseName(String courseName) {
        var allByCourseName = userRepository.findUsersByCourseName(courseName);
        log.info("Found [{}] users by course name [{}]", allByCourseName.size(), courseName);
        return userMapper.toDto(allByCourseName);
    }

    public List<UserDto> getUsersByCourseId(Long courseId) {
        var usersByCourseId = userRepository.findUsersByCourseId(courseId);
        log.info("Found [{}] users by course id [{}]", usersByCourseId.size(), courseId);
        return userMapper.toDto(usersByCourseId);
    }

    public UserDto createUser(CreateUserDto userDto) {
        var entityDto = userMapper.toEntityDto(userDto);
        var savedUser = userRepository.save(entityDto);
        log.info("User [{}] created", savedUser.getId());
        return userMapper.toDto(savedUser);
    }
}
