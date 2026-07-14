package com.crud.demo.dto;
import com.crud.demo.entity.BookType;
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