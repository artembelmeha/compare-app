package com.ukd.userapi.controller.api;

import java.util.List;

import com.ukd.userapi.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Course Api")
public interface CourseApi {

    @Operation(summary = "Search user by Course name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "With list of users (can be empty)"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    List<UserDto> getUsersByCourseName(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational,
                                       @Parameter(description = "Search users who enrolled in course with name") String courseName);

    @Operation(summary = "Search user by Course id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "With list of users (can be empty)"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not fount course with such id"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    List<UserDto> getUsersByCourseName(@Parameter(description = "Flag to direct request to relational or graph service") boolean isRelational,
                                       @Parameter(description = "Search users who enrolled in course id") Long courseId);
}
