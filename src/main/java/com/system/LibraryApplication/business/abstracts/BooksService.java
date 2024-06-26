package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.entities.concretes.Books;
import java.util.List;
import java.util.Optional;

public interface BooksService {
    List<Books> findAll();
    Optional<Books> findById(Long id);
    Books save(Books authors);
    void deleteById(Long id);
}
