package com.ukd.graphuserservice.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ukd.graphuserservice.domain.Course;
import com.ukd.graphuserservice.dto.CourseDto;


@Mapper(componentModel = SPRING)
public interface CourseMapper {

    @Mapping(target = "courseName", source = "name")
    @Mapping(target = "courseDescription", source = "description")
    CourseDto toDto(Course course);

    List<CourseDto> toDto(List<Course> courses);
}
