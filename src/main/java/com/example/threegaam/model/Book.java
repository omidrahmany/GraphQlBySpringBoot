package com.example.threegaam.model;

public class Book {

    private Long bookId;
    private Long userId;
    private String createdAt;
    private String title;
    private String isbn;

    public Book(Long bookId, Long userId, String createdAt, String title, String isbn) {
        this.bookId = bookId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.title = title;
        this.isbn = isbn;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

