package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.core.entities.Books;
import com.system.LibraryApplication.core.entities.Borrows;

import java.util.List;
import java.util.Optional;

public interface BorrowsService {
    List<Borrows> findAll();
    Optional<Borrows> findById(Long id);
    Borrows save(Borrows borrows);
    void deleteById(Long id);
}
