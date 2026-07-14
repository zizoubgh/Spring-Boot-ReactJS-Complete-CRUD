package com.crud.backendSpringboot.service;

import com.crud.backendSpringboot.entity.Book;
import com.crud.backendSpringboot.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;

    // Constructor Injection
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return repository.findById(id).map(book -> {
            book.setName(updatedBook.getName());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublishedDate(updatedBook.getPublishedDate());
            book.setPrice(updatedBook.getPrice());
            book.setBookType(updatedBook.getBookType());
            return repository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}