package com.system.LibraryApplication.dataAccess.abstracts;

import com.system.LibraryApplication.entities.concretes.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Optional<Authors> findByNameSurnameIgnoreCase(String nameSurname);
}
