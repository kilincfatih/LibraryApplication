package com.system.LibraryApplication.business.rules;

import com.system.LibraryApplication.business.messages.BooksMessages;
import com.system.LibraryApplication.business.messages.BorrowsMessages;
import com.system.LibraryApplication.core.utilities.exceptions.types.BusinessException;
import com.system.LibraryApplication.dataAccess.abstracts.BooksRepository;
import com.system.LibraryApplication.dataAccess.abstracts.BorrowsRepository;
import com.system.LibraryApplication.entities.concretes.Books;
import com.system.LibraryApplication.entities.concretes.Borrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BorrowsBusinessRules {
    private final BorrowsRepository borrowsRepository;

    @Autowired
    public BorrowsBusinessRules(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }

    public void idMustExist(Long id) {
        Optional<Borrows> existingBorrow = borrowsRepository.findById(id);
        if (existingBorrow.isEmpty()) {
            throw new BusinessException(BorrowsMessages.idIsNotExists);
        }
    }

}
