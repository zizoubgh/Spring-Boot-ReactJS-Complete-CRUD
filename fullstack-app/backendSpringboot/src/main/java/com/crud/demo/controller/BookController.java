package com.crud.backendSpringboot.controller;

import com.crud.backendSpringboot.dto.BookDTO;
import com.crud.backendSpringboot.entity.Book;
import com.crud.backendSpringboot.service.BookService; // أو الـ Repository مباشرة حسب هيكلة مشروعك

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        // 1. تحويل الـ DTO (POJO) إلى Entity يدوياً
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublishedDate(bookDTO.getPublishedDate());
        book.setPrice(bookDTO.getPrice());
        book.setBookType(bookDTO.getBookType());

        // 2. حفظ الـ Entity في قاعدة البيانات
        Book savedBook = bookService.saveBook(book);

        return ResponseEntity.ok(savedBook);
    }

    // get all books
    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    // 3. Update Existing Book
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book updatedBookFields = new Book();
        updatedBookFields.setName(bookDTO.getName());
        updatedBookFields.setIsbn(bookDTO.getIsbn());
        updatedBookFields.setPublishedDate(bookDTO.getPublishedDate());
        updatedBookFields.setPrice(bookDTO.getPrice());
        updatedBookFields.setBookType(bookDTO.getBookType());

        Book updatedBook = bookService.updateBook(id, updatedBookFields);
        return ResponseEntity.ok(updatedBook);
    }

    // 4. Delete Book
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully with id: " + id);
    }
}