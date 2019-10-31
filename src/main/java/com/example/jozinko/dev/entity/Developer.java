package com.example.jozinko.dev.entity;

import java.util.StringJoiner;

public class Developer {

    public String message;
    public int age;

    public Developer(String message, int age) {
        this.message = message;
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Developer.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .add("age=" + age)
                .toString();
    }
}
