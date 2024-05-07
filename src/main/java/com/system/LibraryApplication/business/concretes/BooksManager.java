package com.system.LibraryApplication.business.concretes;

import com.system.LibraryApplication.business.abstracts.BooksService;
import com.system.LibraryApplication.core.entities.Books;
import com.system.LibraryApplication.dataAccess.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BooksManager implements BooksService {
    private final BooksRepository booksRepository ;

    @Autowired
    public BooksManager(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Books> findById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Books save(Books author) {
        return booksRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }
}
