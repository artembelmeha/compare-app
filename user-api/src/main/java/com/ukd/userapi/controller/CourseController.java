package com.ukd.userapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ukd.userapi.dto.UserDto;
import com.ukd.userapi.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsersByCourseName(@RequestParam(required = false, defaultValue = "true") boolean isRelational,
                                              @RequestParam String courseName) {
        return userService.getUsersByCourseName(isRelational, courseName);
    }
}
