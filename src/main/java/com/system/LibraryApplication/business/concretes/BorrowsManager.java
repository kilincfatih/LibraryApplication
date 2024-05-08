package com.system.LibraryApplication.business.concretes;

import com.system.LibraryApplication.business.abstracts.BorrowsService;
import com.system.LibraryApplication.core.entities.Borrows;
import com.system.LibraryApplication.dataAccess.BorrowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowsManager implements BorrowsService {
    private final BorrowsRepository borrowsRepository ;

    @Autowired
    public BorrowsManager(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }

    @Override
    public List<Borrows> findAll() {
        return borrowsRepository.findAll();
    }

    @Override
    public Optional<Borrows> findById(Long id) {
        return borrowsRepository.findById(id);
    }

    @Override
    public Borrows save(Borrows author) {
        return borrowsRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        borrowsRepository.deleteById(id);
    }
}
