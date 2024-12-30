package com.ukd.relationaluserservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.relationaluserservice.dto.CourseDto;
import com.ukd.relationaluserservice.mapper.CourseMapper;
import com.ukd.relationaluserservice.repository.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getCoursesByUserId(Long userId) {
        var courseList = courseRepository.findCoursesByUserId(userId);
        return courseMapper.toDto(courseList);
    }
}

