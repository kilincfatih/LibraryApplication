package com.system.LibraryApplication.api.controllers;

import com.system.LibraryApplication.business.abstracts.BooksService;
import com.system.LibraryApplication.core.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> books = booksService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        Optional<Books> books = booksService.findById(id);
        return books.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        Books newBook = booksService.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books bookDetails) {
        Optional<Books> book = booksService.findById(id);
        if (book.isPresent()) {
            Books existingBook = book.get();
            existingBook.setIsbn(bookDetails.getIsbn());
            existingBook.setBookName(bookDetails.getBookName());
            existingBook.setPublicationDate(bookDetails.getPublicationDate());
            existingBook.setLanguage(bookDetails.getLanguage());
            existingBook.setPageCount(bookDetails.getPageCount());
            Books updatedBook = booksService.save(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (booksService.findById(id).isPresent()) {
            booksService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
