package com.ukd.userapi.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ukd.userapi.dto.CourseDto;
import com.ukd.userapi.dto.UserDto;
import com.ukd.userapi.service.CourseService;
import com.ukd.userapi.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final CourseService courseService;

    @GetMapping("/count")
    public String countAllUsers(@RequestParam(required = false, defaultValue = "true") boolean isRelational) {
        return userService.getAllUsers(isRelational);
    }

    @GetMapping("/search")
    public List<UserDto> getUsers(@RequestParam(required = false, defaultValue = "true") boolean isRelational,
                                  @RequestParam String userName) {
        return userService.getUsersByFirstName(isRelational, userName);
    }

    @GetMapping("/{userId}/courses")
    public List<CourseDto> getUserCourses(@PathVariable Long userId,
                                          @RequestParam(required = false, defaultValue = "true") boolean isRelational) {
        return courseService.getCoursesByUserId(userId, isRelational);
    }

}
