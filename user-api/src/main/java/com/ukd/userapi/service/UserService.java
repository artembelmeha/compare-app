package com.ukd.userapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.userapi.client.GraphUserServiceClient;
import com.ukd.userapi.client.RelationUserServiceClient;
import com.ukd.userapi.dto.CreateUserDto;
import com.ukd.userapi.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private RelationUserServiceClient relationUserServiceClient;
    private GraphUserServiceClient graphUserServiceClient;

    public String getAllUsers(boolean relational) {
        log.info("Getting all users from [{}]", relational ? "relation" : "graph");
        return relational ? relationUserServiceClient.getCountAll() :
                graphUserServiceClient.getCountAll();
    }

    public List<UserDto> getUsersByFirstName(boolean relational, String userName) {
        log.info("Getting users by first name from [{}]", relational ? "relation" : "graph");
        return relational ? relationUserServiceClient.getUsersByFirstName(userName) :
                graphUserServiceClient.getUsersByFirstName(userName);
    }

    public List<UserDto> getUsersByCourseName(boolean relational, String courseName) {
        log.info("Getting users by course name from [{}]", relational ? "relation" : "graph");
        return relational ? relationUserServiceClient.getUsersByCourseName(courseName) :
                graphUserServiceClient.getUsersByCourseName(courseName);
    }

    public List<UserDto> getUsersByCourseId(boolean isRelational, Long courseId) {
        log.info("Getting users by course id from [{}]", isRelational ? "relation" : "graph");
        return isRelational ? relationUserServiceClient.getUsersByCourseId(courseId) :
                graphUserServiceClient.getUsersByCourseId(courseId);
    }

    public UserDto createUser(CreateUserDto userDto, boolean isRelational) {
        log.info("Creating user in [{}]", isRelational ? "relation" : "graph");
        return isRelational ? relationUserServiceClient.createUser(userDto) :
                graphUserServiceClient.createUser(userDto);
    }

    public void deleteUser(Long userId, boolean isRelational) {
        log.info("Deleting user [{}] from [{}]", userId, isRelational ? "relation" : "graph");
        if (isRelational) {
            relationUserServiceClient.deleteUser(userId);
        } else {
            graphUserServiceClient.deleteUser(userId);
        }
    }

    public List<UserDto> getUsersEnrolledInSameCourses(boolean isRelational, Long userId) {
        log.info("Getting users enrolled in same courses from [{}]", isRelational ? "relation" : "graph");
        return isRelational ? relationUserServiceClient.getUsersEnrolledInSameCourses(userId) :
                graphUserServiceClient.getUsersEnrolledInSameCourses(userId);
    }

    public UserDto getUserById(boolean isRelational, Long userId) {
        log.info("Getting user by id from [{}]", isRelational ? "relation" : "graph");
        return isRelational ? relationUserServiceClient.getUsersById(userId) :
                graphUserServiceClient.getUsersById(userId);
    }
}
