package ru.panina.springproject.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;

public class Book {

    @NotEmpty(message = "Title shouldn't be empty")
    private String title;

    @NotEmpty(message = "The book should have an author")
    private String author;

    @NotEmpty(message = "Publish year couldn't be empty")
    @Max(value = 2024, message = "The book can't be from future")
    private String publishYear;

    public Book(String title, String author, String publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
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

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
