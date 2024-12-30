package com.ukd.userapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.userapi.client.GraphUserServiceClient;
import com.ukd.userapi.client.RelationUserServiceClient;
import com.ukd.userapi.dto.CourseDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CourseService {
    private RelationUserServiceClient relationUserServiceClient;
    private GraphUserServiceClient graphUserServiceClient;

    public List<CourseDto> getCoursesByUserId(Long userId, boolean isRelational) {
        log.info("Getting courses for user: {}", userId);
        return isRelational ? relationUserServiceClient.getCoursesByUserId(userId) :
                graphUserServiceClient.getCoursesByUserId(userId);
    }
}
