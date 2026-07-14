package com.crud.backendSpringboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String isbn;
    private LocalDate publishedDate;
    private Double price;
    
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    // Constructors
    public Book() {}

    public Book(Long id, String name, String isbn, LocalDate publishedDate, Double price, BookType bookType) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
        this.bookType = bookType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public BookType getBookType() { return bookType; }
    public void setBookType(BookType bookType) { this.bookType = bookType; }
}