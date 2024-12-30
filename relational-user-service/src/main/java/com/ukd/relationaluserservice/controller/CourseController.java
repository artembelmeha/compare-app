package com.ukd.relationaluserservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ukd.relationaluserservice.dto.UserDto;
import com.ukd.relationaluserservice.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsersByCourseName(@RequestParam String courseName) {
        log.info("Getting users by course name: {}", courseName);
        return userService.getUsersByCourseName(courseName);
    }

    @GetMapping("/{courseId}/users")
    public List<UserDto> getUsersByCourseName(@PathVariable Long courseId) {
        log.info("Getting users by course id: {}", courseId);
        return userService.getUsersByCourseId(courseId);
    }
}
