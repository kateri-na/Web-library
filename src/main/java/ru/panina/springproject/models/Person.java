package ru.panina.springproject.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class Person {
    private int id;

    @NotEmpty(message = "Укажите имя пользователя")
    private String name;

    @Min(value = 1900, message = "Проверьте год рождения ещё раз")
    @Max(value = 2023, message = "Пользователю должен быть хотя бы 1 год")
    private int year;

    public Person() {}

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
