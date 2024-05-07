package com.system.LibraryApplication.dataAccess;

import com.system.LibraryApplication.core.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
