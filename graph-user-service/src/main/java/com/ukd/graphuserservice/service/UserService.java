package com.ukd.graphuserservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.graphuserservice.dto.UserDto;
import com.ukd.graphuserservice.mapper.UserMapper;
import com.ukd.graphuserservice.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String countAll() {
        return String.valueOf(userRepository.findAll().size());
    }

    public List<UserDto> getUsers(String userName) {
        var usersByFirstName = userRepository.findUsersByFirstName(userName);
        return userMapper.toDto(usersByFirstName);
    }

    public List<UserDto> getUsersByCourseName(String courseName) {
        var usersByCourseName = userRepository.findUsersByCourseName(courseName);
        log.info("Found [{}] users by course name [{}]", usersByCourseName.size(), courseName);
        return userMapper.toDto(usersByCourseName);
    }
}