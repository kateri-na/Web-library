package ru.panina.springproject.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;

public class Book {
    private int id;
    private int personId;

    @NotEmpty(message = "Title shouldn't be empty")
    private String title;

    @NotEmpty(message = "The book should have an author")
    private String author;

    @Max(value = 2024, message = "The book can't be from future")
    private int year;

    public Book() {}

    public Book(int id, int personId, String title, String author, int year) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
