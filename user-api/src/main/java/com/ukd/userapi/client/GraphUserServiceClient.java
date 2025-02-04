package com.ukd.userapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ukd.userapi.annotation.LogExecutionTime;
import com.ukd.userapi.dto.CourseDto;
import com.ukd.userapi.dto.CreateUserDto;
import com.ukd.userapi.dto.UserDto;

@Component
@FeignClient(name = "graph-user-service")
public interface GraphUserServiceClient {

    @LogExecutionTime
    @GetMapping("/users")
    String getCountAll();

    @LogExecutionTime
    @GetMapping("/users/search")
    List<UserDto> getUsersByFirstName(@RequestParam String userName);

    @LogExecutionTime
    @GetMapping("/courses/users")
    List<UserDto> getUsersByCourseName(@RequestParam String courseName);

    @LogExecutionTime
    @GetMapping("users/{userId}/courses")
    List<CourseDto> getCoursesByUserId(@PathVariable Long userId);

    @LogExecutionTime
    @GetMapping("courses/{courseId}/users")
    List<UserDto> getUsersByCourseId(@PathVariable Long courseId);

    @LogExecutionTime
    @PostMapping("/users")
    UserDto createUser(@RequestBody CreateUserDto userDto);

    @LogExecutionTime
    @DeleteMapping("users/{userId}")
    void deleteUser(@PathVariable Long userId);

    @LogExecutionTime
    @GetMapping("users/{userId}/co-users")
    List<UserDto> getUsersEnrolledInSameCourses(@PathVariable Long userId);

    @LogExecutionTime
    @GetMapping("users/{userId}")
    UserDto getUsersById(@PathVariable Long userId);

}
