package com.ukd.userapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ukd.userapi.controller.api.CourseApi;
import com.ukd.userapi.dto.UserDto;
import com.ukd.userapi.service.UserService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController implements CourseApi {
    private final UserService userService;

    @Override
    @GetMapping("/users")
    public List<UserDto> getUsersByCourseName(@RequestParam(required = false, defaultValue = "true") boolean isRelational,
                                              @RequestParam String courseName) {
        return userService.getUsersByCourseName(isRelational, courseName);
    }

    @Override
    @GetMapping("/{courseId}/users")
    public List<UserDto> getUsersByCourseName(@RequestParam(required = false, defaultValue = "true") boolean isRelational,
                                              @PathVariable Long courseId) {
        return userService.getUsersByCourseId(isRelational, courseId);
    }
}
