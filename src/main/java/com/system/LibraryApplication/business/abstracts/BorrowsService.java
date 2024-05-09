package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.entities.concretes.Borrows;
import java.util.List;
import java.util.Optional;

public interface BorrowsService {
    List<Borrows> findAll();
    Optional<Borrows> findById(Long id);
    Borrows save(Borrows borrows);
    void deleteById(Long id);
}
