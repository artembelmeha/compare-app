package com.ukd.graphuserservice.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Integer credits;
    private String semester;
}
