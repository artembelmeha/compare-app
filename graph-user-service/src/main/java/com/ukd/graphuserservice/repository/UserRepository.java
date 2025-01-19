package com.ukd.graphuserservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.ukd.graphuserservice.domain.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (n:User) RETURN n")
    List<User> findAll();

    List<User> findUsersByFirstName(String name);

    @Query("MATCH (c:Course {name: $courseName})<-[:ENROLLED_IN]-(u:User) RETURN u")
    List<User> findUsersByCourseName(String courseName);

    @Query("MATCH (u:User)-[:ENROLLED_IN]->(c:Course) WHERE ID(c) = $courseId RETURN u")
    List<User> findUsersByCourseId(Long courseId);

    @Query("MATCH (user:User)-[:ENROLLED_IN]->(course:Course)<-[:ENROLLED_IN]-(similarUser:User) " +
            "WHERE ID(user) = $userId AND ID(user) <> ID(similarUser) " +
            "RETURN DISTINCT similarUser " +
            "LIMIT 100")
    List<User> findUsersEnrolledInSameCourses(Long userId);
}
