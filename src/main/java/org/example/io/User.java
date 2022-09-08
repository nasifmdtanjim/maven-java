package org.example.io;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private Set<String> roles;

    public User(String name) {
        this.name = name;
    }
}
