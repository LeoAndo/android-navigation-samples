package com.example.navigationjavasample;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private float height;

    public Person(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}
