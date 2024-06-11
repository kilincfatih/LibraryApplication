package com.system.LibraryApplication.dataAccess.abstracts;

import com.system.LibraryApplication.entities.concretes.Authors;
import com.system.LibraryApplication.entities.concretes.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {
    Optional<Books> findByBookNameIgnoreCase(String bookName);
}
