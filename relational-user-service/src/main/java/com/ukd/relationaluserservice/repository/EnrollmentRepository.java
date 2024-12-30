package com.ukd.relationaluserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ukd.relationaluserservice.domain.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
