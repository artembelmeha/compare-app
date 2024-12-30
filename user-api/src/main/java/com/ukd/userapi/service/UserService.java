package com.ukd.userapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.userapi.client.GraphUserServiceClient;
import com.ukd.userapi.client.RelationUserServiceClient;
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
}
