package com.system.LibraryApplication.dataAccess;

import com.system.LibraryApplication.core.entities.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowsRepository extends JpaRepository <Borrows, Long> {
}
