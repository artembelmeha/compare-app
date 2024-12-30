package com.ukd.relationaluserservice.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    STUDENT("student"),
    PROFESSOR("professor");

    String name;
}
