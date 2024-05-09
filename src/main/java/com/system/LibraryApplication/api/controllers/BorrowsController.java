package com.system.LibraryApplication.api.controllers;

import com.system.LibraryApplication.business.abstracts.BorrowsService;
import com.system.LibraryApplication.entities.concretes.Borrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {
    private final BorrowsService borrowsService;

    @Autowired
    public BorrowsController(BorrowsService borrowsService) {
        this.borrowsService = borrowsService;
    }

    @GetMapping
    public ResponseEntity<List<Borrows>> getAllBorrows() {
        List<Borrows> borrows = borrowsService.findAll();
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrows> getBorrowById(@PathVariable Long id) {
        Optional<Borrows> borrows = borrowsService.findById(id);
        return borrows.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Borrows> createBorrow(@RequestBody Borrows borrows) {
        Borrows newBorrow = borrowsService.save(borrows);
        return new ResponseEntity<>(newBorrow, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrows> updateBorrow(@PathVariable Long id, @RequestBody Borrows borrowDetails) {
        Optional<Borrows> borrow = borrowsService.findById(id);
        if (borrow.isPresent()) {
            Borrows existingBorrow = borrow.get();
            existingBorrow.setBorrowDate(borrowDetails.getBorrowDate());
            existingBorrow.setReturnDate(borrowDetails.getReturnDate());
            existingBorrow.setWasItReturned(borrowDetails.getWasItReturned());
            Borrows updatedBorrow = borrowsService.save(existingBorrow);
            return new ResponseEntity<>(updatedBorrow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long id) {
        if (borrowsService.findById(id).isPresent()) {
            borrowsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
