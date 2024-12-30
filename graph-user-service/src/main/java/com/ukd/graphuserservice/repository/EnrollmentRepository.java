package com.ukd.graphuserservice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.ukd.graphuserservice.domain.Enrollment;

@Repository
public interface EnrollmentRepository extends Neo4jRepository<Enrollment, Long> {
}

