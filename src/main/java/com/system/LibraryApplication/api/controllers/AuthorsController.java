package com.system.LibraryApplication.api.controllers;

import com.system.LibraryApplication.business.abstracts.AuthorsService;
import com.system.LibraryApplication.entities.concretes.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
        private final AuthorsService authorsService;

        @Autowired
        public AuthorsController(AuthorsService authorsService) {
            this.authorsService = authorsService;
        }

        @GetMapping
        public ResponseEntity<List<Authors>> getAllAuthors() {
            List<Authors> authors = authorsService.findAll();
            return new ResponseEntity<>(authors, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
            Optional<Authors> author = authorsService.findById(id);
            return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping
        public ResponseEntity<Authors> createAuthor(@RequestBody Authors author) {
            Authors newAuthor = authorsService.save(author);
            return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Authors> updateAuthor(@PathVariable Long id, @RequestBody Authors authorDetails) {
            Optional<Authors> author = authorsService.findById(id);
            if (author.isPresent()) {
                Authors existingAuthor = author.get();
                existingAuthor.setNameSurname(authorDetails.getNameSurname());
                existingAuthor.setBirthDate(authorDetails.getBirthDate());
                Authors updatedAuthor = authorsService.save(existingAuthor);
                return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
            if (authorsService.findById(id).isPresent()) {
                authorsService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
