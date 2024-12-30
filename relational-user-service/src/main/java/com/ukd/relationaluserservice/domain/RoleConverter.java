package com.ukd.relationaluserservice.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute.name;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.STUDENT.name.equalsIgnoreCase(dbData) ? Role.STUDENT : Role.PROFESSOR;
    }
}
