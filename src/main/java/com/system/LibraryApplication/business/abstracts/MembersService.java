package com.system.LibraryApplication.business.abstracts;

import com.system.LibraryApplication.core.entities.Members;
import java.util.List;
import java.util.Optional;

public interface MembersService {
    List<Members> findAll();
    Optional<Members> findById(Long id);
    Members save(Members members);
    void deleteById(Long id);
}
