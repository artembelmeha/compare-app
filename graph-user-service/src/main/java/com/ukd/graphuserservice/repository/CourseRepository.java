package com.ukd.graphuserservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.ukd.graphuserservice.domain.Course;

@Repository
public interface CourseRepository extends Neo4jRepository<Course, Long> {

    @Query("MATCH (u:User)-[:ENROLLED_IN]->(c:Course) WHERE ID(u) = $userId RETURN c")
    List<Course> findCoursesByUserId(Long userId);
}
