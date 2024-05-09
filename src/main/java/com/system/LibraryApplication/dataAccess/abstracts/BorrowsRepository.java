package com.system.LibraryApplication.dataAccess.abstracts;

import com.system.LibraryApplication.entities.concretes.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowsRepository extends JpaRepository <Borrows, Long> {
}
