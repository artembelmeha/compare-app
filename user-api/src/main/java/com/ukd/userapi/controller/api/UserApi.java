package com.ukd.userapi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ukd.userapi.dto.CourseDto;
import com.ukd.userapi.dto.CreateUserDto;
import com.ukd.userapi.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Api")
public interface UserApi {

    @Operation(summary = "Count all users managed by service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Number of users"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    String countAllUsers(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational);

    @Operation(summary = "Search user course enrolled by user using user name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "With list of course user enrolled in"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not fount user with such id"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    List<UserDto> getUsers(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational,
                           @Parameter(description = "Search courses enrolled by user") String userName);

    @Operation(summary = "Search user course enrolled by user using user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "With list of course user enrolled in"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not fount user with such id"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    List<CourseDto> getUserCourses(@Parameter(description = "Search courses enrolled by id") Long userId,
                                   @Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational);

    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    UserDto createUser(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational,
                       @Parameter(description = "User to create") CreateUserDto userDto);

    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not fount user with such id"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    void deleteUser(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational,
                    @Parameter(description = "User to delete") Long userId);

    @Operation(summary = "Get first 100 users enrolled in the same course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "List of Users enrolled in the same course"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    List<UserDto> getCoUsers(@RequestParam(required = false, defaultValue = "true") boolean isRelational,
                             @PathVariable Long userId);

}
