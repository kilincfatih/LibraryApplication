package com.system.LibraryApplication.dataAccess;

import com.system.LibraryApplication.core.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
