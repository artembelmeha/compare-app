package com.ukd.userapi.service;

import org.springframework.stereotype.Service;

import com.ukd.userapi.client.RelationUserServiceClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private RelationUserServiceClient relationUserServiceClient;
    public String getAllUsers() {
        log.info("Getting request from RelationUserServiceClient");
        return relationUserServiceClient.getAll();
    }
}
