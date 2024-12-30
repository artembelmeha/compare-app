package com.ukd.relationaluserservice.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "course_name")
    private String courseName;
    @JoinColumn(name = "course_description")
    private String courseDescription;
    @JoinColumn(name = "course_credits")
    private Integer courseCredits;
    private String semester;
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
