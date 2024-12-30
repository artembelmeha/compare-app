package com.ukd.graphuserservice.domain;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;

@Node
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "address")
    private String address;

    @Property(name = "date_of_birth")
    private String dateOfBirth;

    @Property(name = "email")
    private String email;

    @Property(name = "first_name")
    private String firstName;

    @Property(name = "last_name")
    private String lastName;

    @Property(name = "phone_number")
    private String phoneNumber;

    @Property(name = "role")
    private String role;

    @Relationship(type = "ENROLLED_IN", direction = Relationship.Direction.OUTGOING)
    private List<Enrollment> enrollments;
}
