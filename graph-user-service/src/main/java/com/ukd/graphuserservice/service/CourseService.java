package com.ukd.graphuserservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ukd.graphuserservice.dto.CourseDto;
import com.ukd.graphuserservice.mapper.CourseMapper;
import com.ukd.graphuserservice.repository.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getCoursesByUserId(Long userId) {
        log.info("Getting courses by user id: {}", userId);
        var coursesByUserId = courseRepository.findCoursesByUserId(userId);
        return courseMapper.toDto(coursesByUserId);
    }
}
