package com.peueueu.sbcourseproject.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String cpf;

    public User(int id, String name, String cpf) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }
}
