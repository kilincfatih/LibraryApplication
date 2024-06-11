package com.system.LibraryApplication.business.rules;

import com.system.LibraryApplication.business.messages.AuthorsMessages;
import com.system.LibraryApplication.core.utilities.exceptions.types.BusinessException;
import com.system.LibraryApplication.dataAccess.abstracts.AuthorsRepository;
import com.system.LibraryApplication.entities.concretes.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class AuthorsBusinessRules {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsBusinessRules(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public void authorNameCannotBeDuplicated(String nameSurname) {
        Optional<Authors> existingAuthor = authorsRepository.findByNameSurnameIgnoreCase(nameSurname);
        if (existingAuthor.isPresent()) {
            throw new BusinessException(AuthorsMessages.authorNameAlreadyExists);
        }
    }

    public void idMustExist(Long id) {
        Optional<Authors> existingAuthor = authorsRepository.findById(id);
        if (existingAuthor.isEmpty()) {
            throw new BusinessException(AuthorsMessages.idIsNotExists);
        }
    }

    public void authorNameMustExist(String nameSurname) {
        Optional<Authors> existingAuthor = authorsRepository.findByNameSurnameIgnoreCase(nameSurname);
        if (existingAuthor.isEmpty()) {
            throw new BusinessException(AuthorsMessages.authorNameIsNotExists);
        }
    }
}
