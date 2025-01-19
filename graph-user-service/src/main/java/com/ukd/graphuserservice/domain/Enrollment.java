package com.ukd.graphuserservice.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;
    @TargetNode
    private Course course;
    private String date;
    private String grade;
}
