package com.ukd.relationaluserservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ukd.relationaluserservice.dto.CourseDto;
import com.ukd.relationaluserservice.dto.UserDto;
import com.ukd.relationaluserservice.service.CourseService;
import com.ukd.relationaluserservice.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final CourseService courseService;

    @GetMapping
    public String getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<UserDto> getUsers(@RequestParam String userName) {
        return userService.getUsers(userName);
    }

    @GetMapping("/{userId}/courses")
    public List<CourseDto> getUserCourses(@PathVariable Long userId) {
        log.info("Getting courses for user: {}", userId);
        return courseService.getCoursesByUserId(userId);
    }
}
