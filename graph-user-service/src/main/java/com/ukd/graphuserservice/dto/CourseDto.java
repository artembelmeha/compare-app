package com.ukd.graphuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String courseName;
    private String courseDescription;
    private Integer courseCredits;
    private String semester;
}
