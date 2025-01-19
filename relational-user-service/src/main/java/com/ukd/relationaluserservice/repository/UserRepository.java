package com.ukd.relationaluserservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ukd.relationaluserservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getAllByFirstName(String userName);

    @Query("SELECT u FROM User u JOIN u.enrollments e JOIN e.course c WHERE c.courseName = :courseName")
    List<User> findUsersByCourseName(String courseName);

    @Query("SELECT u FROM User u JOIN u.enrollments e JOIN e.course c WHERE c.id = :courseId")
    List<User> findUsersByCourseId(Long courseId);

    @Query(value = "SELECT DISTINCT u.* FROM users u " +
            "JOIN enrollments e ON u.id = e.user_id " +
            "JOIN enrollments e2 ON e.course_id = e2.course_id " +
            "WHERE e2.user_id = :userId AND u.id <> :userId " +
            "LIMIT 100", nativeQuery = true)
    List<User> findUsersEnrolledInSameCourses(Long userId);

}
