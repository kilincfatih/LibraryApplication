package com.system.LibraryApplication.business.rules;

import com.system.LibraryApplication.business.messages.CategoriesMessages;
import com.system.LibraryApplication.business.messages.MembersMessages;
import com.system.LibraryApplication.core.utilities.exceptions.types.BusinessException;
import com.system.LibraryApplication.dataAccess.abstracts.CategoriesRepository;
import com.system.LibraryApplication.dataAccess.abstracts.MembersRepository;
import com.system.LibraryApplication.entities.concretes.Categories;
import com.system.LibraryApplication.entities.concretes.Members;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MembersBusinessRules {
    private final MembersRepository membersRepository;

    @Autowired
    public MembersBusinessRules(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public void idMustExist(Long id) {
        Optional<Members> existingMembers = membersRepository.findById(id);
        if (existingMembers.isEmpty()) {
            throw new BusinessException(MembersMessages.idIsNotExists);
        }
    }
}
