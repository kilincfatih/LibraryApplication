package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.entities.concretes.Authors;
import java.util.List;
import java.util.Optional;

public interface AuthorsService {
    List<Authors> findAll();
    Optional<Authors> findById(Long id);
    Authors save(Authors authors);
    void deleteById(Long id);
}
