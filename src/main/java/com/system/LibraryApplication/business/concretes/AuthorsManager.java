package com.system.LibraryApplication.business.concretes;

import com.system.LibraryApplication.business.abstracts.AuthorsService;
import com.system.LibraryApplication.core.entities.Authors;
import com.system.LibraryApplication.dataAccess.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsManager implements AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsManager(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public List<Authors> findAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Optional<Authors> findById(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public Authors save(Authors author) {
        return authorsRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorsRepository.deleteById(id);
    }
}
