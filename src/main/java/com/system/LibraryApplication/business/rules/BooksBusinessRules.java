package com.system.LibraryApplication.business.rules;

import com.system.LibraryApplication.business.messages.BooksMessages;
import com.system.LibraryApplication.core.utilities.exceptions.types.BusinessException;
import com.system.LibraryApplication.dataAccess.abstracts.BooksRepository;
import com.system.LibraryApplication.entities.concretes.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksBusinessRules {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksBusinessRules(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void bookNameCannotBeDuplicated(String bookName) {
        Optional<Books> existingBook = booksRepository.findByBookNameIgnoreCase(bookName);
        if (existingBook.isPresent()) {
            throw new BusinessException(BooksMessages.bookNameAlreadyExists);
        }
    }

    public void idMustExist(Long id) {
        Optional<Books> existingBook = booksRepository.findById(id);
        if (existingBook.isEmpty()) {
            throw new BusinessException(BooksMessages.idIsNotExists);
        }
    }

    public void bookNameMustExist(String bookName) {
        Optional<Books> existingBook = booksRepository.findByBookNameIgnoreCase(bookName);
        if (existingBook.isEmpty()) {
            throw new BusinessException(BooksMessages.bookNameIsNotExists);
        }
    }
}
