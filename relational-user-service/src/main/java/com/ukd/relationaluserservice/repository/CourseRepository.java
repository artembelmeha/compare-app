package com.ukd.relationaluserservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ukd.relationaluserservice.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c JOIN c.enrollments e WHERE e.user.id = :userId")
    List<Course> findCoursesByUserId(Long userId);
}
