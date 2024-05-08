package com.system.LibraryApplication.business.concretes;

import com.system.LibraryApplication.business.abstracts.MembersService;
import com.system.LibraryApplication.core.entities.Members;
import com.system.LibraryApplication.dataAccess.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MembersManager implements MembersService {
    private final MembersRepository membersRepository ;

    @Autowired
    public MembersManager(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public List<Members> findAll() {
        return membersRepository.findAll();
    }

    @Override
    public Optional<Members> findById(Long id) {
        return membersRepository.findById(id);
    }

    @Override
    public Members save(Members members) {
        return membersRepository.save(members);
    }

    @Override
    public void deleteById(Long id) {
        membersRepository.deleteById(id);
    }
}
