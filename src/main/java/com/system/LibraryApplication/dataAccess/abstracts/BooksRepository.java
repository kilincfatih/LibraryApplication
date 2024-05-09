package com.system.LibraryApplication.dataAccess.abstracts;

import com.system.LibraryApplication.entities.concretes.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
