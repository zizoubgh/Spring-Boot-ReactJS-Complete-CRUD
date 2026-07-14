package com.crud.backendSpringboot.dto;
import com.crud.backendSpringboot.entity.BookType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookDTO {
    private String name;
    private String isbn;
    private LocalDate publishedDate;
    private Double price;
    private BookType bookType;
}