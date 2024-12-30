package com.ukd.relationaluserservice.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import com.ukd.relationaluserservice.domain.Course;
import com.ukd.relationaluserservice.dto.CourseDto;

@Mapper(componentModel = SPRING)
public interface CourseMapper {
    CourseDto toDto(Course course);

    List<CourseDto> toDto(List<Course> courses);
}
